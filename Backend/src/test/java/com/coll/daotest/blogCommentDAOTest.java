package com.coll.daotest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.blogCommentDAO;
import com.coll.sections.blogComment;

public class blogCommentDAOTest {
	static blogCommentDAO blogcommentDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogcommentDAO=(blogCommentDAO)context.getBean("blogcommentDAO");
	}
	@Test
	public void addblogcommentTest() {
		blogComment blogcomment=new blogComment();
		blogcomment.setBlogId(529);
		blogcomment.setBlogComment("nice");
		blogcomment.setCommentDate(new java.util.Date());
		blogcomment.setUsername("admin");
		System.out.println("just for fun");
		assertTrue("problem in adding blog comment",blogcommentDAO.addBlogComment(blogcomment));
	}
	@Ignore
	@Test
	public void getblogcommenttest() {
		assertNotNull("problem in getting blogcomment",blogcommentDAO.getBlogComment(501));
	}
	@Ignore
	@Test
	public void updateblogcommenttest() {
		blogComment blogcomment=blogcommentDAO.getBlogComment(501);
		blogcomment.setBlogId(529);
		assertTrue("problem in adding blog comment",blogcommentDAO.updateBlogComment(blogcomment));
	}
	@Ignore
	@Test
	public void deleteblogcomment() {
		blogComment blogcomment=blogcommentDAO.getBlogComment(501);
		assertTrue("problem in deleting blog comment",blogcommentDAO.deleteBlogComment(blogcomment));
	}

	@Test
	public void listblogcomment() {
		List<blogComment> listComments=blogcommentDAO.getblogComments();
	    for(blogComment blogcomment:listComments) {
	    	System.out.println("id:"+blogcomment.getCommentId());
	    }
	}
}

