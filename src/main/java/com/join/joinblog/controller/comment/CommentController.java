package com.join.joinblog.controller.comment;

import com.join.joinblog.entity.comment.Comment;
import com.join.joinblog.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/addWithBlog")
    public boolean addCommentWithBlog(int userid, int blogid, String comments, String username,String bereplyeduser)  throws Exception{
        Comment comment1 = new Comment();
        comment1.setUserid(userid);
        comment1.setBlogid(blogid);
        comment1.setComments(comments);
        comment1.setUsername(username);
        comment1.setBereplyeduser(bereplyeduser);
        return commentService.addCommentWithBlog(comment1);
    }

    @RequestMapping(value = "/addWithComment")
    public boolean addCommentWithComment(int userid, String comments, String username,int commentid,String bereplyeduser)  throws Exception{
        Comment comment1 = new Comment();
        comment1.setUserid(userid);
        comment1.setCommentid(commentid);
        comment1.setComments(comments);
        comment1.setUsername(username);
        comment1.setBereplyeduser(bereplyeduser);
        return commentService.addCommentWithComment(comment1);
    }

    @RequestMapping(value = "/delete")
    public boolean deleteComment(int id)  throws Exception{
        return commentService.deleteComment(id);
    }

    @RequestMapping(value = "/query")
    public List<Comment> query(String comments) throws Exception{
        List<Comment> list = commentService.query(comments);
        return list;
    }

    @RequestMapping(value = "/list")
    public List<Comment> listComment() throws Exception{
        List<Comment> list = commentService.listComment();
        return list;
    }

    @RequestMapping(value = "/praise")
    public boolean praiseComment( Integer id, int praise) throws Exception{
        return commentService.praiseComment(id,praise);
    }

    @RequestMapping(value = "/queryByBlogid")
    public List<Comment> queryByBlogid(int blogid) throws Exception{
        List<Comment> list = commentService.queryByBlogid(blogid);
        return list;
    }

    @RequestMapping(value = "/queryByCommentid")
    public List<Comment> queryByCommentid(int commentid) throws Exception{
        List<Comment> list = commentService.queryByCommentid(commentid);
        return list;
    }
}
