package com.frygo.movieflix.movie.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frygo.movieflix.user.entity.User;

@Entity
@Table
public class MovieReview {
	MovieReview(){
		
	}
	MovieReview(String newid, String newuser, String newcomment, Integer newrate){
		this.id = newid;
		this.user = newuser;
		this.comment = newcomment;
		this.rate = newrate;
		
	}
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	@JsonIgnore
	private String id;
	
	private String user;

	private String comment;

	private Integer rate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

}
