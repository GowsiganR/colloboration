package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.blogCommentDAO;
import com.coll.sections.blogComment;

@RestController
public class blogCommentRestController {
	@Autowired
	blogCommentDAO blogcommentDAO;
	
	@GetMapping("/getBlogComments") 
	public ResponseEntity<List<blogComment>> getBlogComments() 
	{
		List<blogComment> listBlogComments=blogcommentDAO.getblogComments();
		if(listBlogComments.size()>0) {
			return new ResponseEntity<List<blogComment>>(listBlogComments,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<blogComment>>(listBlogComments,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getBlogComment/{commentId}") 
	public ResponseEntity<blogComment> getBlogComment(@PathVariable("commentId") int commentId)
	{
		blogComment blogcomment=blogcommentDAO.getBlogComment(commentId);
		return new ResponseEntity<blogComment>(blogcomment,HttpStatus.OK);
	}

@PostMapping("/addBlogComment")
public ResponseEntity<String> addBlogComment(@RequestBody blogComment blogcomment)
{
	blogcomment.setCommentDate(new java.util.Date());
	blogcomment.setUsername("Gowsigan");
	if(blogcommentDAO.addBlogComment(blogcomment))
	{
		return new ResponseEntity<String>("BlogComment added",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error adding blogcomment",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PostMapping("/updateBlogComment")
public ResponseEntity<String> updateBlogComment(@RequestBody blogComment blogcomment)
{
	if(blogcommentDAO.updateBlogComment(blogcomment)) 
	{
		return new ResponseEntity<String>("BlogComment updated",HttpStatus.OK);
	}
	else 
	{
		return new ResponseEntity<String>("Error updating blogcomment",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/deleteBlogComment/{commentId}")
public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId") int commentId)
{
	blogComment blogcomment=blogcommentDAO.getBlogComment(commentId);
	if(blogcommentDAO.deleteBlogComment(blogcomment)) 
	{
		return new ResponseEntity<String>("Blogcomment deleted",HttpStatus.OK);
	}
	else 
	{
		return new ResponseEntity<String>("Error deleting blogcomment",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
}

