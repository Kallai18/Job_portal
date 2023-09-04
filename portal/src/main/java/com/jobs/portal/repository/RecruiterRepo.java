package com.jobs.portal.repository;

import com.jobs.portal.modal.RecruiterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepo extends JpaRepository<RecruiterModel,Long> {
    RecruiterModel findByEmailAndPassword(String email, String password);
}
