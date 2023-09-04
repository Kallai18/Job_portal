package com.jobs.portal.dto;

import java.sql.Date;

public class FileDTO {
    public Long getFileId() {
        return fileId;
    }

    public void setFileID(Long fileID) {
        this.fileId = fileID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    private Long fileId;
    private Long userId;
    private Date createdDate;
}
