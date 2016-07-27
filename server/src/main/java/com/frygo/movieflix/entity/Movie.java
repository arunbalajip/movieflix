package com.frygo.movieflix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:mtitle") 
})
public class Movie {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	private String title;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Year year;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Rated rated;
	@ManyToMany(cascade = {CascadeType.ALL})
	
	private List<Genre> genres;
	@OneToOne(cascade = {CascadeType.ALL})
	Cast cast;
	public Cast getCast() {
		return cast;
	}
	public void setCast(Cast cast) {
		this.cast = cast;
	}
	@ManyToMany(cascade = {CascadeType.ALL})

	private List<Language> languages;
	@ManyToMany(cascade = {CascadeType.ALL})
	
	private List<Country> countries;
	private String Awards;
	@OneToOne(cascade = {CascadeType.ALL})
	private IMDB imbd;
	@OneToOne(cascade = {CascadeType.ALL})
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