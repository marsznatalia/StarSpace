package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "content")
    private String content;
    @Column(name = "datePosted")
    private Date datePosted;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Reaction> reactionList;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> children;

    @ElementCollection(targetClass = Like.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "likes", joinColumns = @JoinColumn(name = "like_id"))
    @Column(name = "likes", nullable = false)
    private List<Like> likes = new ArrayList<>();

    public Comment() {

    }

    public Comment(long id, String content, Date datePosted, User author, Post post, Comment parent, List<Reaction> reactionList, List<Comment> children, List<Like> likes) {
        this.id = id;
        this.content = content;
        this.datePosted = datePosted;
        this.author = author;
        this.post = post;
        this.parent = parent;
        this.reactionList = reactionList;
        this.children = children;
        this.likes = likes;
    }

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public List<Reaction> getReactionList() {
        return reactionList;
    }

    public void setReactionList(List<Reaction> reactionList) {
        this.reactionList = reactionList;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}


