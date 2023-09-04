package com.jobs.portal.service;

import com.jobs.portal.dto.FileDTO;
import com.jobs.portal.modal.FileModel;
import com.jobs.portal.repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    @Autowired
    FileRepo fileRepo;
    public String saveFile(FileDTO app){
        FileModel modal =new FileModel();
        modal.setFileID(app.getFileId());
        modal.setCreatedDate(app.getCreatedDate());
        modal.setUserId(app.getUserId());
         fileRepo.save(modal);
        return "Saved Successfully";
    }
    public List<FileModel> getAllFile(){
        return fileRepo.findAll();
    }

}
