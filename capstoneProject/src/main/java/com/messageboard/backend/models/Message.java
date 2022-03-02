package com.messageboard.backend.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="messages")
public class Message {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="post")
	private String post;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;
//	@Column(name="user_id")
//	private int user_id;
	
	@PrePersist
	private void onCreate() {
		this.date=new Date();
	}
	
//	Creating one to one relationship between user and message
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}
	
	public String getPost() {
		return post;
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}

	public Date getDate() {
		return date;
	}
	
//	public int getUser_id() {
//		return user_id;
//	}
		
	
}
