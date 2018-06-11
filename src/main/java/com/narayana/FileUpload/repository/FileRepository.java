package com.narayana.FileUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narayana.FileUpload.model.FileMetaData;

public interface FileRepository extends JpaRepository<FileMetaData, Integer> {

}
