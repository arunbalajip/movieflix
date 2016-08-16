package com.frygo.movieflix.movie.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:mtitle") })
public class Movie {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	private String title;

	private Integer year;

	private String rated;

	private String genre;
	@OneToOne(cascade = { CascadeType.ALL })
	Cast cast;

	@OneToMany(cascade = { CascadeType.ALL })
	List<MovieReview> userreviews;

	public List<MovieReview> getUserreviews() {
		return userreviews;
	}

	public void setUserreviews(List<MovieReview> userreviews) {
		this.userreviews = userreviews;
	}

	public Cast getCast() {
		return cast;
	}

	public void setCast(Cast cast) {
		this.cast = cast;
	}

	@ManyToOne(cascade = { CascadeType.ALL })
	private Language languages;

	@ManyToOne(cascade = { CascadeType.ALL })
	private Country countries;

	private String Awards;
	@OneToOne(cascade = { CascadeType.ALL })
	private IMDB imbd;
	@OneToOne(cascade = { CascadeType.ALL })
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getGenres() {
		return genre;
	}

	public void setGenres(String genres) {
		this.genre = genres;
	}

	public Language getLanguages() {
		return languages;
	}

	public void setLanguages(Language languages) {
		this.languages = languages;
	}

	public Country getCountries() {
		return countries;
	}

	public void setCountries(Country countries) {
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