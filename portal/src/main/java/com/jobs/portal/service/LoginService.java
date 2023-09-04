package com.jobs.portal.service;

import com.jobs.portal.dto.LoginDTO;
import com.jobs.portal.modal.ApplicantModel;
import com.jobs.portal.modal.OrganisationModel;
import com.jobs.portal.modal.RecruiterModel;
import com.jobs.portal.repository.ApplicantsRepo;
import com.jobs.portal.repository.OrganisationRepo;
import com.jobs.portal.repository.RecruiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jobs.portal.utils.JWTUtil.generateJwtToken;

@Service
public class LoginService {
    @Autowired
    ApplicantsRepo applicantsRepo;
    @Autowired
    OrganisationRepo organisationRepo;
    @Autowired
    RecruiterRepo recruiterRepo;

    public String login(LoginDTO login){
       ApplicantModel applicant= applicantsRepo.findByEmailAndPassword(login.getEmail(),login.getPassword());
        if(applicant!=null){
            return generateJwtToken(applicant.getName(),"applicant",applicant.getUserID());
        }
        else{
           OrganisationModel org= organisationRepo.findByEmailAndPassword(login.getEmail(),login.getPassword());
            if(org!=null){
                return generateJwtToken(org.getOrganisationName(), "organisation",org.getOrgId());
            }
            else{
                RecruiterModel rec = recruiterRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
                if(rec!=null){
                 return generateJwtToken(rec.getName(), "recruiter",rec.getRecId());
                }
                else {
                    return null;
                }
            }
        }
    }
}
