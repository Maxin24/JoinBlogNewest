package com.join.joinblog.entity.comment;


public class Comment {
    /**
     * 评论的id
     */
    private int id;
    /**
     * 评论者的id
     */
    private int userid;
    /**
     * 被评论的博客的id
     */
    private int blogid;
    /**
     * 评论内容
     */
    private String comments;
    /**
     * 评论时间
     */
    private String  tim = null;
    /**
     * 被评论的评论的id
     */
    private int commentid;

    /**
     *点赞数
     */
    private int praise;

    /**
     * 评论的用户名
     */
    private String username;

    /**
     * 被评论的用户名
     */
    private String bereplyeduser;

    /**
     * 评论者的头像
     */
    private String userurl;

    /**
     * 被评论者的头像
     */
    private String bereplyeduserurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBereplyeduser() {
        return bereplyeduser;
    }

    public void setBereplyeduser(String bereplyeduser) {
        this.bereplyeduser = bereplyeduser;
    }

    public String getUserurl() {
        return userurl;
    }

    public void setUserurl(String userurl) {
        this.userurl = userurl;
    }

    public String getBereplyeduserurl() {
        return bereplyeduserurl;
    }

    public void setBereplyeduserurl(String bereplyeduserurl) {
        this.bereplyeduserurl = bereplyeduserurl;
    }

    public Comment() {
    }

    /**
     * 评论博客的评论
     * @param id
     * @param blogid
     * @param comments
     * @param username
     */
    public Comment(int id, int userid, int blogid, String comments, String username,String userurl,String bereplyeduserurl) {
        this.id = id;
        this.userid = userid;
        this.blogid = blogid;
        this.comments = comments;
        this.username = username;
        this.userurl = userurl;
        this.bereplyeduserurl = bereplyeduserurl;
    }

    /**
     * 评论评论的评论
     * @param id
     * @param comments
     * @param username
     * @param commentid
     */

    public Comment(int id, int userid, String comments, String username, int commentid,String userurl,String bereplyeduserurl) {
        this.id = id;
        this.userid = userid;
        this.comments = comments;
        this.username = username;
        this.commentid = commentid;
        this.userurl = userurl;
        this.bereplyeduserurl = bereplyeduserurl;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userid=" + userid +
                ", blogid=" + blogid +
                ", comments='" + comments + '\'' +
                ", tim=" + tim +
                ", commentid=" + commentid +
                '}';
    }
}