package com.join.joinblog.service.comment;

import com.join.joinblog.entity.comment.Comment;

import java.util.List;

public interface CommentService {

    public boolean addCommentWithBlog(Comment comment) throws Exception;

    public boolean addCommentWithComment(Comment comment)throws Exception;

    public boolean deleteComment(int id) throws Exception;

    public List<Comment> query(String comments) throws Exception;

    public List<Comment> listComment() throws Exception;

    public boolean praiseComment(int id, int praise) throws Exception;

    public List<Comment> queryByBlogid(int blogid) throws Exception;

    public List<Comment> queryByCommentid(int commentid) throws Exception;
}
