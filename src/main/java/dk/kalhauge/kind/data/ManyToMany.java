package dk.kalhauge.kind.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ManyToMany<A extends Entity, B extends Entity> {
  private final static Map<String, ManyToMany> instances = new HashMap<>();
  private final Map<A, Relation> references = new HashMap<>();
  private final ManyToMany<B, A> twin;
  
  private ManyToMany(ManyToMany<B, A> twin) {
    this.twin = twin;
    }
  
  private ManyToMany() {
    this.twin = new ManyToMany<>(this);
    }
  
  public static <A extends Entity, B extends Entity> 
      ManyToMany<A, B> intance(Class<A> typeA, Class<B> typeB, String name) {
    String fullName = typeA.getName()+"-"+name+"-"+typeB.getName();
    ManyToMany<A, B> instance = instances.get(fullName);
    if (instance == null) {
      instance = new ManyToMany<>();
      instances.put(fullName, instance);
      String twinName = typeB.getName()+"-"+name+"-"+typeA.getName();
      instances.put(twinName, instance.twin);
      }
    return instance;
    }
  
  public Set<B> list(A source) {
    Relation targets = references.get(source);
    if (targets == null) references.put(source, targets = new Relation(source));
    return targets;
    }
  
  private Relation relation(A source) {
    return new Relation(source);
    }
  
  boolean addRelation(A source, B target) {
    Relation targets = references.get(source);
    if (targets == null) references.put(source, targets = relation(source));
    targets.addRaw(target);
    ManyToMany<B, A>.Relation sources = twin.references.get(target);
    if (sources == null) twin.references.put(target, sources = twin.relation(target));
    return sources.addRaw(source);
    }
  
  private class Relation extends HashSet<B> {
    private final A source;

    Relation(A source) {
      this.source = source;
      }

    @Override
    public boolean add(B target) {
      return addRelation(source, target);
      }

    private boolean addRaw(B target) {
      return super.add(target);
      }
  
    }

  }
