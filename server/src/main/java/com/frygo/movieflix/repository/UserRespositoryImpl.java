package com.frygo.movieflix.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frygo.movieflix.user.entity.User;


@Repository
@Transactional

public class UserRespositoryImpl implements UserRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("Movie.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}


	@Override
	public User create(User user) {
		em.persist(user);		
		return user;
	}

	@Override
	public User update(String id, User user) {
		// TODO Auto-generated method stub
		return em.merge(user);
	}

	@Override
	public void delete(User id) {
		em.remove(em);
		
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return new User();
	}
}
