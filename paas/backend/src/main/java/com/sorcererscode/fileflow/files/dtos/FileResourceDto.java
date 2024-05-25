package com.sorcererscode.fileflow.files.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.Resource;

@Builder
@Data
public class FileResourceDto {
    private Resource resource;
    private String mimeType;
}
