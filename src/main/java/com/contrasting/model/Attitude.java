package com.contrasting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attitude {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String trait;
	private String descrip;
	private int minimum;

	public Attitude() {
	}

	public Attitude(String trait, String descrip, int minimum) {
		super();
		this.trait = trait;
		this.descrip = descrip;
		this.minimum = minimum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrait() {
		return trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
}
