package com.sorcererscode.fileflow.files.dtos;

import com.sorcererscode.fileflow.organisations.dtos.OrganisationResponse;
import lombok.Data;

@Data
public class StoredFolderDto {
    private Long id;
    private String folderName;
    private OrganisationResponse organisation;
    private StoredFolderDto folder;
}
