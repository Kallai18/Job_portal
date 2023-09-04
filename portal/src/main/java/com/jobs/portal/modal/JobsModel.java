package com.jobs.portal.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobsModel {
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Long postedBy) {
        this.postedBy = postedBy;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExRangeMin() {
        return exRangeMin;
    }

    public void setExRangeMin(int exRangeMin) {
        this.exRangeMin = exRangeMin;
    }

    public int getExRangeMax() {
        return exRangeMax;
    }

    public void setExRangeMax(int exRangeMax) {
        this.exRangeMax = exRangeMax;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;
    private Long postedBy;
    private String jobTitle;
    private String description;
    private int exRangeMin;
    private int exRangeMax;
    private boolean isActive;
}
