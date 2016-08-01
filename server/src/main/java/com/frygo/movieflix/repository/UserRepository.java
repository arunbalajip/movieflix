package com.frygo.movieflix.repository;

import java.util.List;


import com.frygo.movieflix.user.entity.User;



public interface UserRepository {
	public List<User> findAll();
	public User findOne(String id);
	public User create(User movie);
	public User update(String id, User movie);
	public void delete(User id);
	public User findByUserName(String title);
}

