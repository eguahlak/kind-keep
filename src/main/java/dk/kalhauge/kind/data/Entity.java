package dk.kalhauge.kind.data;

public abstract class Entity<K> {
  private final K key;
  
  protected Entity(K key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    this.key = key;
    }
  
  public K getKey() { return key; }

  @Override public int hashCode() { return key.hashCode(); }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (other.getClass() == getClass()) return key.equals(((Entity)other).key);
    return false;
    }
  
  }
