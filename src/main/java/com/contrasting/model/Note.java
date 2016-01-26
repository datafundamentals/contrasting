package com.contrasting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String text;
	private String category;

	public Note() {
	}

	public Note(String text, String category) {
		super();
		this.text = text;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
