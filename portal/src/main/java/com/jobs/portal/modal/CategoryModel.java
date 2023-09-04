package com.jobs.portal.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryModel {
    public Long getCategoryID() {
        return categoryId;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryId = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String categoryName;
}
