package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private User author;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private Set<Reaction> reactionList;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Comment> children;

    public Comment() {

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Set<Reaction> getReactionList() {
        return reactionList;
    }

    public void setReactionList(Set<Reaction> reactionList) {
        this.reactionList = reactionList;
    }

    public Set<Comment> getChildren() {
        return children;
    }

    public void setChildren(Set<Comment> children) {
        this.children = children;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}


