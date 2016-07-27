package com.frygo.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table
public class Year {
	@Id
	@GenericGenerator(name="customUUID",strategy="uuid2")
	@GeneratedValue(generator="customUUID")
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
