package com.jobs.portal.service;

//import com.jobs.portal.dto.LoginDTO;
import com.jobs.portal.dto.OrganisationDTO;
import com.jobs.portal.modal.OrganisationModel;
import com.jobs.portal.repository.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService {
@Autowired
    OrganisationRepo organisationRepo;
public String saveOrganisation (OrganisationDTO app){
    OrganisationModel modal=new OrganisationModel();
    modal.setEmail(app.getEmail());
    modal.setPassword(app.getPassword());
    modal.setOrganisationName(app.getOrganisationName());
    modal.setCategory(app.getCategory());
    modal.setOrgId(app.getOrgId());
    modal.setUserName(app.getUserName());
     organisationRepo.save(modal);
    return "Saved Successfully";
}
public List<OrganisationModel> getAllOrganisation(){
    return organisationRepo.findAll();
}

}
