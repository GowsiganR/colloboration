package com.coll.sections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Friend {
	
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendid")
@SequenceGenerator(name="friendid",allocationSize=1,sequenceName="friendidseq")
private int friendId;
private String username;
private String friendName;
private String friendFirstName;
private String friendLastName;
private String status;

public int getFriendId() {
	return friendId;
}
public void setFriendId(int friendId) {
	this.friendId = friendId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

public String getFriendName() {
	return friendName;
}
public void setFriendName(String friendName) {
	this.friendName = friendName;
}
public String getStatus() {
	return status;
}

public String getFriendFirstName() {
	return friendFirstName;
}
public void setFriendFirstName(String friendFirstName) {
	this.friendFirstName = friendFirstName;
}
public String getFriendLastName() {
	return friendLastName;
}
public void setFriendLastName(String friendLastName) {
	this.friendLastName = friendLastName;
}

public void setStatus(String status) {
	this.status = status;
}
}
