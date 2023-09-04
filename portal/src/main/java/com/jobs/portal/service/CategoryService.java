package com.jobs.portal.service;

import com.jobs.portal.dto.CategoryDTO;
import com.jobs.portal.modal.CategoryModel;
import com.jobs.portal.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    public String saveCategory(CategoryDTO app){
        CategoryModel modal =new CategoryModel();
        modal.setCategoryID(app.getCategoryID());
        modal.setCategoryName(app.getCategoryName());
         categoryRepo.save(modal);
        return "Saved Successfully";
    }
public List<CategoryModel> getAllCategory(){
        return categoryRepo.findAll();
}
}
