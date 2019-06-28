package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.sections.blogComment;

@Repository("blogCommentDAO")
@Transactional
public class blogCommentDAOImpl implements blogCommentDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addBlogComment(blogComment blogcomment) {
		try {
			sessionFactory.getCurrentSession().save(blogcomment);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}
	
	@Override
	public List<blogComment> getblogComments() {
		Session session=sessionFactory.openSession();
	    Query query=session.createQuery("from blogComment");
	    List<blogComment> listComments=query.list();
	    return listComments;
	}
	
	@Override
	public boolean updateBlogComment(blogComment blogcomment) {
		
		try {
			sessionFactory.getCurrentSession().update(blogcomment);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}
	
	@Override
	public boolean deleteBlogComment(blogComment blogcomment) {
			
			try {
				sessionFactory.getCurrentSession().delete(blogcomment);
				return true;
			}
			catch(Exception e) {
			return false;
			}
		
	}
	
	@Override
	public blogComment getBlogComment(int commentId) {
		Session session=sessionFactory.openSession();
		blogComment blogcomment=session.get(blogComment.class,commentId);
		session.close();
		return blogcomment;
	}



	
	}
