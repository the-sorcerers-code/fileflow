package com.sorcererscode.fileflow.files.dtos;

import lombok.Data;

@Data
public class StoredFileDto {
    private Long id;
    private String savedName;
    private String originalName;
    private String mimeType;
    private long fileSize;
    private String downloadUrl;

}