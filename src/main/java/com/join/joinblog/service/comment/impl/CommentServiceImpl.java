package com.join.joinblog.service.comment.impl;

import com.join.joinblog.entity.comment.Comment;
import com.join.joinblog.mapper.comment.CommentMapper;
import com.join.joinblog.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean addCommentWithBlog(Comment comment) throws Exception {
        return commentMapper.addCommentWithBlog(comment);
    }

    @Override
    public boolean addCommentWithComment(Comment comment)throws Exception {
        return commentMapper.addCommentWithComment(comment);
    }

    @Override
    public boolean deleteComment(int id) throws Exception {
        return commentMapper.deleteComment(id);
    }

    @Override
    public List<Comment> query(String comments) throws Exception{
        List<Comment> list = Collections.emptyList();
        list = commentMapper.query(comments);
        return list;
    }

    @Override
    public List<Comment> listComment() throws Exception{
        List<Comment> list = Collections.emptyList();
        list = commentMapper.listComment();
        return list;
    }

    @Override
    public boolean praiseComment(int id,int praise) throws Exception{
        return commentMapper.praiseComment(id,praise);
    }

    @Override
    public List<Comment> queryByBlogid(int blogid) throws Exception{
        List<Comment> list = Collections.emptyList();
        list = commentMapper.queryByBlogid(blogid);
        return list;
    }

    public List<Comment> queryByCommentid(int commentid) throws Exception{
        List<Comment> list = Collections.emptyList();
        list = commentMapper.queryByCommentid(commentid);
        return list;
    }
}
