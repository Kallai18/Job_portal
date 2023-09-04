package com.jobs.portal.controller;

//import com.jobs.portal.dto.LoginDTO;
import com.jobs.portal.dto.OrganisationDTO;
import com.jobs.portal.modal.OrganisationModel;
import com.jobs.portal.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organisation")
public class OrganisationController {
    @Autowired
    OrganisationService service;
    @PostMapping("")
        public ResponseEntity<?> saveOrganisation(@RequestBody OrganisationDTO app){
        String res = service.saveOrganisation(app);
        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }
    @GetMapping("/get/all")
    public List<OrganisationModel> getAllOrganisation(){
        return service.getAllOrganisation();
    }

}
