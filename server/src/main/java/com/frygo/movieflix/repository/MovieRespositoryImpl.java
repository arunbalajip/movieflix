package com.frygo.movieflix.repository;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frygo.movieflix.movie.entity.Movie;
@Repository
@Transactional

public class MovieRespositoryImpl implements MovieRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(Movie.class, id);
	}


	@Override
	public Movie create(Movie movie) {
		em.persist(movie);		
		return movie;
	}

	@Override
	public Movie update(String id, Movie movie) {
		// TODO Auto-generated method stub
		return em.merge(movie);
	}

	@Override
	public void delete(Movie id) {
		em.remove(em);
		
	}

	@Override
	public Movie findByTitle(String title) {
		// TODO Auto-generated method stub
		return new Movie();
	}
}
