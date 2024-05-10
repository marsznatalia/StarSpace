package com.uep.wap.dto;

import java.util.Set;

public class UserProfileDTO {
    private Long id;
    private String bio;
    private byte[] profilePicture;
    private Boolean status;
    private Set<String> links;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getBio() {
        return bio;
    }

    public Set<String> getLinks() {
        return links;
    }
}
