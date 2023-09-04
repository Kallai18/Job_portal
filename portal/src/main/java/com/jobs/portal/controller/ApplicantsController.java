package com.jobs.portal.controller;

import com.jobs.portal.dto.ApplicantDTO;
import com.jobs.portal.modal.ApplicantModel;
import com.jobs.portal.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("applicants")
public class ApplicantsController {
    @Autowired
    ApplicantService service;

    @PostMapping("")
    public ResponseEntity<?> saveApplicant(@RequestBody  ApplicantDTO app){
        String res= service.saveApplicant(app);
        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return  new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @GetMapping("/get/all")
    public List<ApplicantModel> getAllApplicants(){
        return  service.getAllApplicants();
    }
}
