package com.uep.wap.dto;

import com.uep.wap.model.*;

import java.util.List;

public class UserDTO {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private List<User> friendList;
    private List<Post> postsList;
    private List<Comment> commentsList;
    private List<Like> likesList;
    private Theme theme;
    private List<Chart> chartList;
    private List<Chat> chatList;
    private UserProfile userProfile;
    private Newsletter newsletter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
