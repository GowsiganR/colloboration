package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.FriendDAO;
import com.coll.sections.Friend;

@RestController
public class FriendRestController {
	@Autowired
	FriendDAO friendDAO;
	
	@GetMapping("/getFriend/{friendId}") 
	public ResponseEntity<Friend> getFriend(@PathVariable("friendId") int friendId) 
	{
		Friend friend=friendDAO.getFriend(friendId);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@GetMapping("/showFriendList/{username}")
	public ResponseEntity<List<Friend>> showFriendList(@PathVariable("username") String username) 
	{
		List<Friend> listFriends=friendDAO.showFriendList(username);
		if(listFriends.size()>0)
		{
			return new ResponseEntity<List<Friend>>(listFriends,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Friend>>(listFriends,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
