package com.jobs.portal.controller;

import com.jobs.portal.dto.JobsDTO;
import com.jobs.portal.modal.JobsModel;
import com.jobs.portal.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("jobs")
public class JobsController {
@Autowired
    JobsService service;
@PostMapping("")
    public ResponseEntity<?> saveJobs(@RequestBody JobsDTO app){
    String res = service.saveJobs(app);
    if (res == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }else {
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
@GetMapping("/get/all")
    public List<JobsModel> getAllJobs(){
    return service.getAllJobs();
}
@GetMapping("get/id/{id}")
    public Optional<JobsModel> getById(@PathVariable Long id){
   return service.getByJobId(id);
}
@GetMapping("/get/all/{postedBy}")
    public List <JobsModel> getPostedBy(@PathVariable String postedBy){
    return service.getPostedBy(postedBy);
}
@GetMapping("/get/all/{jobTitle}")
    public List<JobsModel>getAllJobsByTitle(@PathVariable String jobTitle){
    return service.getAllJobsByTitle(jobTitle);
}

}
