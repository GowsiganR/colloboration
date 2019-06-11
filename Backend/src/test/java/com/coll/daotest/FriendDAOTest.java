package com.coll.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.FriendDAO;
import com.coll.sections.Friend;

public class FriendDAOTest {

	static FriendDAO friendDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
	@Test
	public void addfriendtest() {
		Friend friend=new Friend();
		friend.setFriendName("ravi");
		friend.setUsername("admin");
		friend.setStatus("NA");
		System.out.println("just for fun");
		assertTrue("problem in adding friend",friendDAO.addFriend(friend));
	}
	
	@Test
	public void getfriendtest() {
		assertNotNull("problem in getting user",friendDAO.getFriend(502));
	}
    
	@Test
	public void deletefriendtest() {
		Friend friend=friendDAO.getFriend(503);
		assertTrue("problem in adding friend",friendDAO.deleteFriend(friend));
	}
   
	@Test
	public void getfriendstest() {
		List<Friend> listFriends=friendDAO.getFriends("admin");
		for(Friend friend:listFriends) {
			System.out.println("friendname:"+friend.getFriendName());
		}
	}
}
