package com.coll.daotest;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.coll.dao.blogDAO;
import com.coll.sections.Blog;

public class blogDAOTest {
	static blogDAO blogDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogDAO=(blogDAO)context.getBean("blogDAO");
	}
    
	@Test
	public void addblogtest() {
		Blog blog=new Blog();
		blog.setBlogname("blog");
		blog.setBlogcontent("third content");
		blog.setCreateDate(new java.util.Date());
		blog.setUsername("admin");
		assertTrue("problem in adding blog",blogDAO.addBlog(blog));
	}	
	@Ignore
	@Test
	public void getblogtest() {
		assertNotNull("problem in getting blog",blogDAO.getBlog(518));
	}
	@Ignore
	@Test
	public void updateblogtest() {
		Blog blog=blogDAO.getBlog(521);
		blog.setBlogname("second blog");
		assertTrue("problem in updating blog",blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void deleteblogtest() {
		Blog blog=blogDAO.getBlog(571);
		assertTrue("problem in deleting blog",blogDAO.deleteBlog(blog));
	}
	
	@Test
	public void listblogtest() {
		List<Blog> listBlogs=blogDAO.getBlogs();
		for(Blog blog:listBlogs) {
			System.out.println("id:"+blog.getBlogid());
		}
	}
	@Test
	public void incrementlikestest() {
		assertTrue("problem in incrementing likes",blogDAO.incrementLikes(529));
	}
	
	@Test
	public void incrementdislikestest() {
		assertTrue("problem in incrementing likes",blogDAO.incrementDislikes(570));
	}
	
	@Test
	public void approveblogtest() {
		assertTrue("problem in incrementing likes",blogDAO.approveBlog(520));
	}
	@Test
	public void rejectblogtest() {
		assertTrue("problem in incrementing likes",blogDAO.rejectBlog(523));
	}


	}



