package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private Comment children;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private Set<Reaction> reactionList; //stonks

    @OneToMany(mappedBy = "children", cascade = CascadeType.ALL)
    private Set<Comment> parent;

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

    public Comment getChildren() {
        return children;
    }

    public void setChildren(Comment children) {
        this.children = children;
    }

    public Set<Comment> getParent() {
        return parent;
    }

    public void setParent(Set<Comment> parent) {
        this.parent = parent;
    }
}


