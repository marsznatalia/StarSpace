package com.uep.wap.model;


import javax.persistence.*;
import java.util.List;


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
    //@Column(name ="friends")
    //private List<User> friends;


    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private UserProfile userProfile;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Theme theme;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Like> likes;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User(){

    }


}


