package com.jobs.portal.controller;

//import com.jobs.portal.dto.ApplicantDTO;
import com.jobs.portal.dto.FileDTO;
import com.jobs.portal.modal.FileModel;
import com.jobs.portal.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {
@Autowired
    FileService service;
@PostMapping("")
public String saveFile(@RequestBody FileDTO app){
    return service.saveFile(app);
}
@GetMapping("/get/all")
    public List<FileModel>getAllFile(){
    return service.getAllFile();
}



}
