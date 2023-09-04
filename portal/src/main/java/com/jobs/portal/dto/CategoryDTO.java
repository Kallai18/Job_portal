package com.jobs.portal.dto;

public class CategoryDTO {
    public Long getCategoryID() {
        return categoryId;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryId = categoryID;
    }

    public String getCategoryName() {return categoryName;}

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private Long categoryId;
    private String categoryName;
}
