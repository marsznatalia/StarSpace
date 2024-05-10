package com.uep.wap.dto;

import java.util.Date;

public class CommentDTO {
    private long commentID;
    private long postID;
    private long authorID;
    private String content;
    private Date datePosted;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getAuthorID() {
        return authorID;
    }

    public long getCommentID() {
        return commentID;
    }

    public Long getPostID() {
        return postID;
    }
}
