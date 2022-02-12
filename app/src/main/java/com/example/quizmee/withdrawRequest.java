package com.example.quizmee;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class withdrawRequest {
    public withdrawRequest() {
    }

    public withdrawRequest(String userId, String upiadress, String requestedBy) {
        this.userId = userId;
        this.upiadress = upiadress;
        this.requestedBy = requestedBy;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUpiadress() {
        return upiadress;
    }

    public void setUpiadress(String upiadress) {
        this.upiadress = upiadress;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    private String userId;
    private String upiadress;
    private String requestedBy;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @ServerTimestamp
    private Date createAt;

}
