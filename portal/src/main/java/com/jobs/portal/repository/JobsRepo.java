package com.jobs.portal.repository;

import com.jobs.portal.modal.JobsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobsRepo extends JpaRepository<JobsModel,Long> {
    List<JobsModel> findAllByPostedBy(String search);

    List<JobsModel> findAllByJobTitle(String search);


}
