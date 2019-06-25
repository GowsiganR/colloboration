package com.coll.sections;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfilePicture {
	@Id
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	private byte[] image;
}
