package com.join.joinblog.mapper.comment;

import com.join.joinblog.entity.comment.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    public boolean addCommentWithBlog(@Param("comment") Comment comment)throws Exception;

    public boolean addCommentWithComment(@Param("comment") Comment comment) throws Exception;

    public boolean deleteComment(@Param("id") int id) throws Exception;

    public List<Comment> query(@Param("comment") String comments) throws Exception;

    public List<Comment> listComment() throws Exception;

    public boolean praiseComment(@Param("id") int id, @Param("praise") int praise) throws Exception;

    public List<Comment> queryByBlogid(@Param("blogid") int blogid) throws Exception;

    public List<Comment> queryByCommentid(@Param("commentid") int commentid) throws Exception;
}
