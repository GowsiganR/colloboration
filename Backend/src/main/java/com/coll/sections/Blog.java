package com.coll.sections;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Blog {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogid")
@SequenceGenerator(name="blogid",allocationSize=1,sequenceName="blogid_seq")
private int blogid;
private String blogname;
private String blogcontent;
private String username;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
private Date createDate;
private String status;
private int likes;
private int dislikes;
public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public String getBlogcontent() {
		return blogcontent;
	}
	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

}