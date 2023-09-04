package com.jobs.portal.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class FileModel {
    public long getFileID() {
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
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;
    private Long userId;
    private Date createdDate;
}
