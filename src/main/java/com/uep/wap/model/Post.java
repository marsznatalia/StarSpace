package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @Column(name = "datePosted")
    private Date datePosted;

//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private User author;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Reaction> reactionList;

    @ElementCollection(targetClass = Comment.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "comments", joinColumns = @JoinColumn(name = "comment_id"))
    @Column(name = "comments", nullable = false)
    private List<Comment> comments = new ArrayList<>();

    @ElementCollection(targetClass = Like.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "likes", joinColumns = @JoinColumn(name = "like_id"))
    @Column(name = "likes", nullable = false)
    private List<Like> likes = new ArrayList<>();

    public Post() {
    }

//    public Post(long id, String content, Date datePosted, User user, List<Comment> commentList, List<Reaction> reactionList, List<Comment> comments, List<Like> likes) {
//        this.id = id;
//        this.content = content;
//        this.datePosted = datePosted;
//        this.user = user;
//        this.commentList = commentList;
//        this.reactionList = reactionList;
//        this.comments = comments;
//        this.likes = likes;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Reaction> getReactionList() {
        return reactionList;
    }

    public void setReactionList(List<Reaction> reactionList) {
        this.reactionList = reactionList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}


