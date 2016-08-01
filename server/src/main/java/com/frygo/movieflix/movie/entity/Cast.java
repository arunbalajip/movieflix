package com.frygo.movieflix.movie.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Cast {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	@JsonIgnore
	private String id;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Director director;
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Writer> writers;
	@ManyToMany(cascade = {CascadeType.ALL})
	@Column (unique=true)
	private List<Actor> actors;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public List<Writer> getWriters() {
		return writers;
	}
	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
}
