package com.jobs.portal.service;

//import com.jobs.portal.dto.ApplicantDTO;
import com.jobs.portal.dto.JobApplicationDTO;
//import com.jobs.portal.dto.JobsDTO;
//import com.jobs.portal.modal.ApplicantModel;
import com.jobs.portal.modal.JobApplicationModel;
import com.jobs.portal.modal.JobsModel;
import com.jobs.portal.repository.ApplicantsRepo;
import com.jobs.portal.repository.JobApplicationRepo;
import com.jobs.portal.repository.JobsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {
    @Autowired
    JobApplicationRepo resumeRepo;
    @Autowired
    JobsRepo jobsRepo;
    @Autowired
    ApplicantsRepo applicantsRepo;
    public String saveResume(JobApplicationDTO app){
        JobApplicationModel modal =new JobApplicationModel();
        Optional<JobsModel> job = jobsRepo.findById(app.getJobId());
       modal.setApplyDate(new Date());
       modal.setJobId(app.getJobId());
       modal.setPostedBy(job.get().getPostedBy());
       modal.setUserId(app.getUserId());
        resumeRepo.save(modal);
        return "Saved Successfully";
    }
    public List<JobApplicationModel> getAllResume(){
        return resumeRepo.findAll();
    }

}
