package com.coll.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumCommentDAO;
import com.coll.sections.ForumComment;

public class ForumCommentDAOTest {

	static ForumCommentDAO forumcommentDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		forumcommentDAO=(ForumCommentDAO)context.getBean("forumcommentDAO");
	}
	
	@Test
	public void addforumcommenttest() {
		ForumComment forumcomment=new ForumComment();
		forumcomment.setForumId(501);
		forumcomment.setForumComment("not good");
		forumcomment.setCommentDate(new java.util.Date());
		forumcomment.setUsername("admin");
		System.out.println("just for fun");
		assertTrue("problem in adding forum comment",forumcommentDAO.addForumComment(forumcomment));
	}
	
	@Test
	public void getforumcommenttest() {
		assertNotNull("problem in getting forumcomment",forumcommentDAO.getForumComment(501));
	}
	
	@Test
	public void listforumcomment() {
		List<ForumComment> listComments=forumcommentDAO.getForumComments();
	    for(ForumComment forumcomment:listComments) {
	    	System.out.println("id:"+forumcomment.getCommentId());
	    }
	}
	@Ignore
	@Test
     public void updateforumcommenttest() {
			ForumComment forumcomment=forumcommentDAO.getForumComment(502);
			forumcomment.setForumComment("not bad");
			assertTrue("problem in adding forum comment",forumcommentDAO.updateForumComment(forumcomment));
		}
	
   @Ignore	
   @Test
	public void deleteforumcomment() {
			ForumComment forumcomment=forumcommentDAO.getForumComment(503);
			assertTrue("problem in deleting forum comment",forumcommentDAO.deleteForumComment(forumcomment));
		}
		
	

	}
