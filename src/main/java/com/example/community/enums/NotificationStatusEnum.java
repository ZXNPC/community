package com.example.community.enums;

public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1);
    int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
