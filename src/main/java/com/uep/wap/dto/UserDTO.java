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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public void setPostsList(List<Post> postsList) {
        this.postsList = postsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public void setLikesList(List<Like> likesList) {
        this.likesList = likesList;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void setChartList(List<Chart> chartList) {
        this.chartList = chartList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }

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
