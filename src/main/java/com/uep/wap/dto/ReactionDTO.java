package com.uep.wap.dto;

public class ReactionDTO {
    private Long postID;
    private Long userID;
    private Long commentID;

    public ReactionDTO() {
    }

    public Long getPostID() {
        return postID;
    }

    public Long getCommentID() {
        return commentID;
    }

}
