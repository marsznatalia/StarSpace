package com.uep.wap.dto;

public class ThemeDTO {

    private Long userId;
    private boolean color;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isColor() {
        return color;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color){
        this.color = color;
    }
}
