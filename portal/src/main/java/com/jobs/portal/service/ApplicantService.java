package com.jobs.portal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobs.portal.dto.ApplicantDTO;
//import com.jobs.portal.dto.LoginDTO;
import com.jobs.portal.modal.ApplicantModel;
import com.jobs.portal.modal.OrganisationModel;
import com.jobs.portal.repository.ApplicantsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantService {
    @Autowired
    ApplicantsRepo applicantsRepo;

    public String saveApplicant(ApplicantDTO app){
        ApplicantModel modal=new ApplicantModel();
        modal.setEmail(app.getEmail());
        modal.setPassword(app.getPassword());
       modal.setName(app.getName());
       modal.setDob(app.getDob());
       modal.setLocation(app.getLocation());
       modal.setMobile(app.getMobile());
       modal.setfName(app.getfName());
       modal.setGender(app.getGender());
       modal.setUserID(app.getUserID());
       modal.setCurrentOrg(app.getCurrentOrg());
       modal.setUsername(app.getUsername());
        applicantsRepo.save(modal);
        return "Saved Successfully";


    }
    public List<ApplicantModel> getAllApplicants(){
        return applicantsRepo.findAll()
                .stream().map(x->{
            x.setPassword(null);
            return x;
        }).collect(Collectors.toList());
    }

}


