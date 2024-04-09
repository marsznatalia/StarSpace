package com.uep.wap.model;


import javax.persistence.*;
import java.util.List;


//TODO: User, Chat(usersInChat as List), Message, Chart, Post, Comment, Reaction, Like
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;
    @Column(name ="userName")
    private String userName;
    @Column(name ="email")
    private String email;
    @Column(name ="password")
    private String password;

    //TODO: friends jako lista userów
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Like> likes;
    //

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Chat> chat;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Newsletter newsletter;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Theme theme;

    public User(){

    }


}


