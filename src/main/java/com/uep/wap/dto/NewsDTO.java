package com.uep.wap.dto;


import com.uep.wap.model.Newsletter;

import java.util.Date;

public class NewsDTO {
    private String title;
    private Long newsletterID;
    private Newsletter newsletter;
    private String content;
    private Date datePosted;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getNewsletterID() {
        return newsletterID;
    }

    public Newsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
