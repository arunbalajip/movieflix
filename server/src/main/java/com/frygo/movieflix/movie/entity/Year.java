package com.frygo.movieflix.movie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table
public class Year {
	@Id
	@GenericGenerator(name="customUUID",strategy="uuid2")
	@GeneratedValue(generator="customUUID")
	@JsonIgnore
	private String id;
	private short value;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
	}
}
