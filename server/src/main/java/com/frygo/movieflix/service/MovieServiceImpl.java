package com.frygo.movieflix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frygo.movieflix.exception.AlreadyExistsException;
import com.frygo.movieflix.exception.NotFoundException;
import com.frygo.movieflix.movie.entity.Movie;
import com.frygo.movieflix.movie.entity.MovieReview;
import com.frygo.movieflix.repository.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieRepository respository;
	@Override
	public List<Movie> findAll() {
		return respository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie existing = respository.findOne(id);
		if(existing ==null){
			throw new NotFoundException("Movie "+ id + " not found");
		}
		return existing;
	}

	@Override
	public Movie create(Movie movie) {
		Movie existing = respository.findByTitle(movie.getTitle());
		if(existing !=null){
			throw new AlreadyExistsException("Movie "+ movie.getTitle() + " is already in use");
		}
		
		return respository.create(movie);
	}

	@Override
	public Movie update(String id, Movie movie) {
		Movie existing = respository.findOne(id);
		if(existing ==null){
			throw new NotFoundException("Movie "+ id + " not found");
		}

		return respository.update(id, movie);
	}

	@Override
	public void delete(String id) {
		Movie existing = respository.findOne(id);
		if(existing ==null){
			throw new NotFoundException("Movie "+ id + " not found");
		}
		respository.delete(existing);
	}

}
