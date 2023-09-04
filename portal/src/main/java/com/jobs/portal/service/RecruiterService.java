package com.jobs.portal.service;

//import com.jobs.portal.dto.LoginDTO;
import com.jobs.portal.dto.RecruiterDTO;
import com.jobs.portal.modal.OrganisationModel;
import com.jobs.portal.modal.RecruiterModel;
import com.jobs.portal.repository.OrganisationRepo;
import com.jobs.portal.repository.RecruiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {
    @Autowired
    RecruiterRepo recruiterRepo;
    @Autowired
    OrganisationRepo organisationRepo;
    public String  saveRecruiter(RecruiterDTO app){

        RecruiterModel modal = new RecruiterModel();
        modal.setEmail(app.getEmail());
        modal.setLocation(app.getLocation());
        modal.setMobile(app.getMobile());
        modal.setName(app.getName());
        modal.setPassword(app.getPassword());
        modal.setOrgName(app.getOrgName());
        modal.setRecId(app.getRecId());
         recruiterRepo.save(modal);
        return " Saved Successfully";
    }
public List<RecruiterModel> getAllRecruiter(){
        return recruiterRepo.findAll();
}


}
