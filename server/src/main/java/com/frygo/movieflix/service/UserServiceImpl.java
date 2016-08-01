package com.frygo.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frygo.movieflix.exception.AlreadyExistsException;
import com.frygo.movieflix.exception.NotFoundException;
import com.frygo.movieflix.repository.UserRepository;
import com.frygo.movieflix.user.entity.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository respository;
	@Override
	public List<User> findAll() {
		return respository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = respository.findOne(id);
		if(existing ==null){
			throw new NotFoundException("User "+ id + " not found");
		}
		return existing;
	}

	@Override
	public User create(User user) {
		User existing = respository.findByUserName(user.getUsername());
		if(existing !=null){
			throw new AlreadyExistsException("UserName "+ user.getUsername() + " is already in use");
		}
		
		return respository.create(user);
	}
	
	@Override
	public User update(String id, User user) {
		User existing = respository.findOne(id);
		if(existing ==null){
			throw new NotFoundException("User "+ id + " not found");
		}
		return respository.update(id, user);
	}

	@Override
	public void delete(String id) {
		User existing = respository.findOne(id);
		if(existing ==null){
			throw new NotFoundException("User "+ id + " not found");
		}
		respository.delete(existing);
	}
}
