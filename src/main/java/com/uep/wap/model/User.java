package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @ElementCollection(targetClass = User.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "friendList", joinColumns = @JoinColumn(name = "user_id"))
    //nie wiem czy Join Column jest ok
    @Column(name = "friendList", nullable = false)
    private List<User> friendList = new ArrayList<>();

    @ElementCollection(targetClass = Post.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "postsList", joinColumns = @JoinColumn(name = "user_id")) //nie wiem czy Join Column jest ok
    @Column(name = "postsList", nullable = false)
    private List<Post> postsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> postList;

    @ElementCollection(targetClass = Comment.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "commentsList", joinColumns = @JoinColumn(name = "user_id"))
    //nie wiem czy Join Column jest ok
    @Column(name = "commentsList", nullable = false)
    private List<Comment> commentsList = new ArrayList<>();

    @ElementCollection(targetClass = Like.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "likesList", joinColumns = @JoinColumn(name = "user_id")) //nie wiem czy Join Column jest ok
    @Column(name = "likesList", nullable = false)
    private List<Like> likesList = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Theme theme;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Chart> chartList;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Chat> chatList;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Newsletter newsletter;

    public User() {

    }

    public User(long id, String userName, String email, String password, List<User> friendList, List<Post> postsList, List<Post> postList, List<Comment> commentsList, List<Like> likesList, Theme theme, List<Chart> chartList, List<Chat> chatList, UserProfile userProfile, Newsletter newsletter) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.friendList = friendList;
        this.postsList = postsList;
        this.postList = postList;
        this.commentsList = commentsList;
        this.likesList = likesList;
        this.theme = theme;
        this.chartList = chartList;
        this.chatList = chatList;
        this.userProfile = userProfile;
        this.newsletter = newsletter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public List<Post> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Post> postsList) {
        this.postsList = postsList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Like> getLikesList() {
        return likesList;
    }

    public void setLikesList(List<Like> likesList) {
        this.likesList = likesList;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<Chart> getChartList() {
        return chartList;
    }

    public void setChartList(List<Chart> chartList) {
        this.chartList = chartList;
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Newsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }
}


