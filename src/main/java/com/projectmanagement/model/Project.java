package com.projectmanagement.model;
import java.util.List;

public class Project {
  private int id;
  private String title;
  private String description;
  private java.sql.Date startDate;
  private java.sql.Date endDate;
  private Integer managerId;
  private List<Task> tasks;

  public Project() {}
  public int getId(){return id;} public void setId(int id){this.id=id;}
  public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
  public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
  public java.sql.Date getStartDate(){return startDate;} public void setStartDate(java.sql.Date s){this.startDate=s;}
  public java.sql.Date getEndDate(){return endDate;} public void setEndDate(java.sql.Date e){this.endDate=e;}
  public Integer getManagerId(){return managerId;} public void setManagerId(Integer m){this.managerId=m;}
  public List<Task> getTasks(){return tasks;} public void setTasks(List<Task> t){this.tasks=t;}
}
