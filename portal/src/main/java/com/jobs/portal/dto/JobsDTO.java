package com.jobs.portal.dto;

public class JobsDTO {
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


    private Long jobId;
    private Long postedBy;
    private String jobTitle;
    private String description;
    private int exRangeMin;
    private int exRangeMax;
    public boolean active;
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}
