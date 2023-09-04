package com.jobs.portal.repository;

import com.jobs.portal.modal.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryModel,Long> {
}
