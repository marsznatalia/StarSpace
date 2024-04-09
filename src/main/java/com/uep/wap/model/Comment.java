package com.uep.wap.model;

//TODO: połączenie 1 0..* z samym sobą
//TODO: wygenerowanie konstruktora i getterów i setterów

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "content")
    private String content;
    @Column(name = "author")
    private User author;
    @Column(name = "datePosted")
    private Date datePosted;

    @ElementCollection(targetClass = Like.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "likes", joinColumns = @JoinColumn(name = "like_id")) //bazuje na przykladzie userProfile
    @Column(name = "likes", nullable = false)
    private List<Like> likes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Reaction> reactionList;


    public Comment() {

    }
}


