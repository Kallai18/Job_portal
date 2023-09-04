package com.jobs.portal.controller;

import com.jobs.portal.dto.JobApplicationDTO;
import com.jobs.portal.modal.JobApplicationModel;
import com.jobs.portal.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("job-application")
public class JobApplicationController {
    @Autowired
    JobApplicationService service;
@PostMapping("/apply")
    public ResponseEntity<?> saveResume(@RequestBody JobApplicationDTO app){
    String res = service.saveResume(app);
    if (res == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }else {
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }
}
@GetMapping("/get/all")
public List<JobApplicationModel> getAllResume(){
    return service.getAllResume();
}

}
