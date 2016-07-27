package com.frygo.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table
public class Rated {
	@Id
	@GenericGenerator(name="customUUID",strategy="uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;
	private String value;
	Rated(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
