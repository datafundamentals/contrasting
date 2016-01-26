package com.contrasting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String area;
	private long teamMemberId;

	public Task() {
	}

	public Task(String name, String area, long teamMemberId) {
		super();
		this.name = name;
		this.area = area;
		this.teamMemberId = teamMemberId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public long getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(long teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

}
