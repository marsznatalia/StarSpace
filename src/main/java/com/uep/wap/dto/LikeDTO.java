package com.uep.wap.dto;
import com.uep.wap.model.User;

public class LikeDTO {
    private User user;
    private Long reactionID;

    public Long getReactionID() {
        return reactionID;
    }

    public void setReactionID(Long reactionID) {
        this.reactionID = reactionID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
