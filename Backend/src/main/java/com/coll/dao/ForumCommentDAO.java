package com.coll.dao;

import java.util.List;

import com.coll.sections.ForumComment;


public interface ForumCommentDAO {

public boolean addForumComment(ForumComment forumcomment);
public ForumComment getForumComment(int commentId);
public List<ForumComment> getForumComments();
public boolean updateForumComment(ForumComment forumcomment);
public boolean deleteForumComment(ForumComment forumcomment);

}
