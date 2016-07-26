package com.frygo.movieflix.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
@Table
public class Movie {
	@Id
	@GenericGenerator(name="customUUID",strategy="uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;
	@Column(unique=true)
	private String title;
	@ManyToOne
	private Year year;
	@ManyToOne
	private Rated rated;
	@ManyToMany
	private List<Genre> genres;
	@ManyToOne
	private Director director;
	@ManyToMany
	private List<Writer> writers;
	@ManyToMany
	private List<Actor> actors;
	@ManyToMany
	private List<Language> languages;
	@ManyToMany
	private List<Country> countries;
	private String Awards;
	@OneToOne
	private IMDB imbd;
	@OneToOne
	private Type type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public Rated getRated() {
		return rated;
	}
	public void setRated(Rated rated) {
		this.rated = rated;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
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
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		Awards = awards;
	}
	public IMDB getImbd() {
		return imbd;
	}
	public void setImbd(IMDB imbd) {
		this.imbd = imbd;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
}
