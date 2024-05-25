package com.sorcererscode.fileflow.files.services;

import com.sorcererscode.fileflow.files.db.StoredFile;
import com.sorcererscode.fileflow.files.dtos.FileResourceDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void init();

    StoredFile store(MultipartFile file);

    FileResourceDto get(long id);

    FileResourceDto get(String slug);

    StoredFile getStoredFile(long id);

}
