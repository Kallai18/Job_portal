package com.jobs.portal.repository;

import com.jobs.portal.modal.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<FileModel,Long> {
}
