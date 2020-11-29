package com.example.groupproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private Long createdBy;
  @Column(columnDefinition = "boolean default false")
  private boolean complete;
  
  public Long getCreatedBy() {
	    return this.createdBy;
	  }

	  public void setCreatedBy(Long createdBy) {
	    this.createdBy = createdBy;
	  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getComplete() {
    return this.complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

}