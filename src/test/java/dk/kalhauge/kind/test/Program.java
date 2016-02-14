package dk.kalhauge.kind.test;

import java.util.Set;

public class Program {

  public static void main(String... args) {
    Employee e1 = new Employee("kurt", "Kurt Hansen");
    Employee e2 = new Employee("sonja", "Sonja Jensen");
    
    Project p1 = new Project(7l, "TimeEdit");
    Project p2 = new Project(9l, "MTime");
    Project p3 = new Project(13l, "Fronter");
    
    Set<Project> e1ps = e1.getProjects();
    e1ps.add(p1);
    for (Project p : e1ps) System.out.println("#1 "+p.getKey()+": "+p.getTitle());
    e1ps.add(p2);
    for (Project p : e1ps) System.out.println("#2 "+p.getKey()+": "+p.getTitle());
    e1ps.add(p3);
    for (Project p : e1ps) System.out.println("#3 "+p.getKey()+": "+p.getTitle());
    
    e2.getProjects().add(p2);
    p2.getEmployees().add(new Employee("ib", "Iben Larsen"));
    
    for (Employee e : p2.getEmployees()) {
      System.out.println(">>"+e.getKey()+": "+e.getName());
      }
    }
  
  
  }
