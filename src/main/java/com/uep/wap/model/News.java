package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "datePosted")
    private Date datePosted;

    @ManyToOne(optional = false)
    @JoinColumn(name = "newsletter_id")
    private Newsletter newsletter;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "authors", joinColumns = @JoinColumn(name = "news_id"))
    @Column(name = "author", nullable = false)
    private List<String> author = new ArrayList<>();

    public News() {

    }

    public News(long id, String title, String content, Date datePosted, Newsletter newsletter, List<String> author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.datePosted = datePosted;
        this.newsletter = newsletter;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Newsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }
}


