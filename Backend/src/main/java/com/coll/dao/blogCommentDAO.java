package com.coll.dao;

import java.util.List;

import com.coll.sections.blogComment;

public interface blogCommentDAO {
	
public boolean addBlogComment(blogComment blogcomment);
public List<blogComment> getblogComments();
public boolean updateBlogComment(blogComment blogcomment);
public boolean deleteBlogComment(blogComment blogcomment);
public blogComment getBlogComment(int commentId);


}
