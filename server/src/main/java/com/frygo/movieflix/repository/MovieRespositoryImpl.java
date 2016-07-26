package com.frygo.movieflix.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frygo.movieflix.entity.Movie;
@Repository
@Transactional

public class MovieRespositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Movie> findAll() {
		/*Movie movie = new Movie();
		movie.setId(String.valueOf(em.find(newtable.class, 1).getid()));
		//em.persist(movie);
	List<Movie> list = new ArrayList<>();
	list.add(movie);
		// TODO Auto-generated method stub
		return list;*/
		return null;
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
	@Entity
	@Table
	class newtable{
		int id;
		public int getid(){
			return id;
		}
		public void setid(int id){
			this.id = id;
		
		}
	}
}
