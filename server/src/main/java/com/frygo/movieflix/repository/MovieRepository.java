package com.frygo.movieflix.repository;

import java.util.List;

import com.frygo.movieflix.entity.Movie;

public interface MovieRepository {
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie findByTitle(String title);
	public Movie create(Movie movie);
	public Movie update(String id, Movie movie);
	public void delete(Movie id);
}
