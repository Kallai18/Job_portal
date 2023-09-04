package com.jobs.portal.repository;

import com.jobs.portal.modal.ApplicantModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantsRepo extends JpaRepository<ApplicantModel,Long> {
//    ApplicantModel findByUsernameAndPassword(String username, String password);

    ApplicantModel findByEmailAndPassword(String email, String password);
}
