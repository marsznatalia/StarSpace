package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Theme theme;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Newsletter newsletter;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Post> postsList;

    @OneToMany(mappedBy = "userOwner", cascade = CascadeType.ALL)
    private List<Chart> chartList;

    @OneToMany(mappedBy = "author")
    private Set<Comment> commentList;

    @OneToMany(mappedBy = "user")
    private Set<Reaction> reactionsList;

    @ManyToMany(mappedBy = "chatUsersList")
    private Set<Chat> chatList = new HashSet<>(); //lista chatów danego usera

    @OneToMany
    @JoinTable(name = "friends")
    @JoinColumn(name = "person_A_id", referencedColumnName = "id")
    @JoinColumn(name = "person_B_id", referencedColumnName = "id")
    private Set<User> friends = new HashSet<>();


    public User() {

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

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Post> getPostsList() {
        return postsList;
    }

    public void setPostsList(Set<Post> postsList) {
        this.postsList = postsList;
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

    public Set<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(Set<Chat> chatList) {
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

    public Set<Reaction> getReactionsList() {
        return reactionsList;
    }

    public void setReactionsList(Set<Reaction> reactionsList) {
        this.reactionsList = reactionsList;
    }

    public Set<Comment> getCommentList() {
        return commentList;
    }

    public void setComment(Set<Comment> comment) {
        this.commentList = comment;
    }
}