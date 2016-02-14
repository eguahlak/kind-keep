package dk.kalhauge.kind.test;

import dk.kalhauge.kind.data.Entity;
import dk.kalhauge.kind.data.ManyToMany;
import java.util.Set;

public class Employee extends Entity<String> {
  private static final ManyToMany<Employee, Project> projectRelation = 
      ManyToMany.intance(Employee.class, Project.class, "has");
  private String name;

  public Employee(String key, String name) {
    super(key);
    this.name = name;
    }
  
  public String getName() { return name; }

  public void setName(String value) { name = value; }
  
  public Set<Project> getProjects() {
    return projectRelation.list(this);
    }
  
  }
