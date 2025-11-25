package com.projectmanagement.model;

public class Task {
  private int id;
  private int projectId;
  private String title;
  private Integer assigneeId;
  private String status;

  public Task() {}
  public int getId(){return id;} public void setId(int id){this.id=id;}
  public int getProjectId(){return projectId;} public void setProjectId(int p){this.projectId=p;}
  public String getTitle(){return title;} public void setTitle(String t){this.title=t;}
  public Integer getAssigneeId(){return assigneeId;} public void setAssigneeId(Integer a){this.assigneeId=a;}
  public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
}
