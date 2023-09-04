package com.jobs.portal.controller;

import com.jobs.portal.dto.LoginDTO;
import com.jobs.portal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("login")
public class LoginController {
    @Autowired
    LoginService service;
    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody LoginDTO app){
        String res= service.login(app);
        if (res==null){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return  new ResponseEntity<>(res,HttpStatus.OK);
        }
    }

}
