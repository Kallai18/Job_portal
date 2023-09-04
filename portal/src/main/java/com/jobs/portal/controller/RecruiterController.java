package com.jobs.portal.controller;

//import com.jobs.portal.dto.LoginDTO;
import com.jobs.portal.dto.RecruiterDTO;
import com.jobs.portal.modal.RecruiterModel;
import com.jobs.portal.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recruiter")
public class RecruiterController {
@Autowired
    RecruiterService service;
@PostMapping("")
    public String saveRecruiter(@RequestBody RecruiterDTO app){
    return service.saveRecruiter(app);
}
@GetMapping("/get/all")
    public List<RecruiterModel> getAllRecruiter(){
    return service.getAllRecruiter();
    }

}
