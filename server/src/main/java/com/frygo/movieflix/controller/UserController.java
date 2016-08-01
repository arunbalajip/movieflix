package com.frygo.movieflix.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frygo.movieflix.service.UserService;
import com.frygo.movieflix.user.entity.User;
@RestController
@RequestMapping(path="user")

public class UserController{

	@Autowired
	UserService service;
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		
		return service.findAll();
	}
	@RequestMapping(method=RequestMethod.GET,path="{id}")
	public User findOne(@PathVariable("id")String id){
		return service.findOne(id);
	}
	@RequestMapping(method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user){
		return service.create(user);
	}
	@RequestMapping(method=RequestMethod.PUT,path="{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String id, @RequestBody User user){
		return service.update(id, user);
	}
	@RequestMapping(method=RequestMethod.DELETE,path="{id}")
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}


	
}
