package com.jobs.portal.service;

import com.jobs.portal.dto.JobsDTO;
//import com.jobs.portal.modal.JobApplicationModel;
import com.jobs.portal.modal.JobsModel;
//import com.jobs.portal.repository.ApplicantsRepo;
import com.jobs.portal.repository.JobsRepo;
import com.jobs.portal.repository.RecruiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsService {
    @Autowired
    JobsRepo jobsRepo;
@Autowired
RecruiterRepo recruiterRepo;

    public String saveJobs(JobsDTO app){
        JobsModel modal = new JobsModel();
        modal.setJobId(app.getJobId());
        modal.setDescription(app.getDescription());
        modal.setJobTitle(app.getJobTitle());
        modal.setExRangeMax(app.getExRangeMax());
        modal.setExRangeMin(app.getExRangeMin());
        modal.setPostedBy(app.getPostedBy());
        modal.setActive(app.isActive());
         jobsRepo.save(modal);
        return "Save Successfully";
    }
    public List<JobsModel> getAllJobs(){
        return jobsRepo.findAll();
    }
    public Optional<JobsModel> getByJobId(Long id){
        Optional<JobsModel> modal=jobsRepo.findById(1L);
        return jobsRepo.findById(id);
    }
public List<JobsModel> getPostedBy(String postedBy){
       return jobsRepo.findAllByPostedBy(postedBy);
}
public List<JobsModel> getAllJobsByTitle(String title){
        return jobsRepo.findAllByJobTitle(title);
}

}
