package com.jobs.portal.repository;

import com.jobs.portal.modal.JobApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepo extends JpaRepository<JobApplicationModel,Long> {
}
