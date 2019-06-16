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
import com.coll.sections.UserDetail;

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
	public void sendfriendrequesttest() {
		Friend friend=new Friend();
		friend.setFriendFirstName("ru");
		friend.setFriendLastName("ku");
		friend.setFriendName("Rukmangathan");
		friend.setUsername("admin");
		friend.setStatus("NA");
		System.out.println("just for fun");
		assertTrue("problem in adding friend",friendDAO.sendFriendRequest(friend));
	}
	
	@Test
	public void getfriendtest() {
		assertNotNull("problem in getting user",friendDAO.getFriend(532));
	}
	
	@Test
	public void acceptfriendrequesttest() {
		Friend friend=friendDAO.getFriend(533);
		assertTrue("problem in adding friend",friendDAO.acceptFriendRequest(friend));
	}
    
	@Test
	public void deletefriendrequesttest() {
		Friend friend=friendDAO.getFriend(534);
		assertTrue("problem in adding friend",friendDAO.deleteFriendRequest(friend));
	}
    
	@Test
	public void showfriendlisttest() {
		List<Friend> listFriends=friendDAO.showFriendList("admin");
		for(Friend friend:listFriends) {
			System.out.println("username:"+friend.getFriendName());
		}
	}
	
	@Test
	public void showpendingfriendrequesttest() {
		List<Friend> listFriends=friendDAO.showPendingFriendRequest("admin");
		for(Friend friend:listFriends) {
			System.out.println("username:"+friend.getFriendName());
		}
	}
	
	@Test
	public void showsuggestedfriendstest() {
		List<UserDetail> listUsers=friendDAO.showSuggestedFriends("admin");
		for(UserDetail userDetail:listUsers) {
			System.out.println("username:"+userDetail.getUsername());
		}
	}
}
