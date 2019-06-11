package com.coll.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumDAO;
import com.coll.sections.Forum;

public class ForumDAOTest {

	static ForumDAO forumDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	
	@Test
	public void addforumtest() {
		Forum forum=new Forum();
		forum.setForumName("forumcom");
		forum.setForumContent("third content");
		forum.setCreateDate(new java.util.Date());
		forum.setUsername("admin");
		forum.setStatus("NA");
		System.out.println("just for fun");
		assertTrue("problem in adding forum",forumDAO.addForum(forum));
	}
	@Test
	public void getforumtest() {
		assertNotNull("problem in getting forum",forumDAO.getForum(502));
	}
	
	@Test
	public void updateforumtest() {
		Forum forum=forumDAO.getForum(501);
		forum.setForumContent("first content");
		assertTrue("problem in updating forum",forumDAO.updateForum(forum));
	}

	@Test
	public void deleteforumtest() {
		Forum forum=forumDAO.getForum(503);
		assertTrue("problem in deleting forum",forumDAO.deleteForum(forum));
	}
	
	@Test
	public void listblogtest() {
		List<Forum> listForums=forumDAO.getForums();
		for(Forum forum:listForums) {
			System.out.println("id:"+forum.getForumId());
		}
	}
	
	@Test
	public void approveforumtest() {
	
		Forum forum=forumDAO.getForum(502);
		assertTrue("problem in approving forum",forumDAO.approveForum(forum));
	}
	
	@Test
	public void rejectforumtest() {
		Forum forum=forumDAO.getForum(502);
		assertTrue("problem in rejecting forum",forumDAO.rejectForum(forum));
	}
}
