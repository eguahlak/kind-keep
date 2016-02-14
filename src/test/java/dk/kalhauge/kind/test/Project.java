package dk.kalhauge.kind.test;

import dk.kalhauge.kind.data.Entity;
import dk.kalhauge.kind.data.ManyToMany;
import java.util.Collection;

public class Project extends Entity<Long> {
  private static final ManyToMany<Project, Employee> employeeRelation =
      ManyToMany.intance(Project.class, Employee.class, "has");
  private String title;
  
  public Project(Long key, String title) {
    super(key);
    this.title = title;
    }

  public String getTitle() { return title; }

  public void setTitle(String title) { this.title = title; }

  public Collection<Employee> getEmployees() {
    return employeeRelation.list(this);
    }
  
  }
