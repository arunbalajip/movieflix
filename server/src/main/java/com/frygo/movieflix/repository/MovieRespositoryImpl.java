package com.frygo.movieflix.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frygo.movieflix.movie.entity.Movie;
@Repository
public class MovieRespositoryImpl implements MovieRepository {

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Movie create(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie update(String id, Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movie findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}