package com.jobs.portal.controller;

import com.jobs.portal.dto.CategoryDTO;
import com.jobs.portal.modal.CategoryModel;
import com.jobs.portal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
@Autowired
    CategoryService service;
@PostMapping("")
    public String saveCategory(@RequestBody CategoryDTO app){
    return service.saveCategory(app);
 }
 @GetMapping("/get/all")
    public List<CategoryModel> getAllCategory(){
    return service.getAllCategory();
    }
}
