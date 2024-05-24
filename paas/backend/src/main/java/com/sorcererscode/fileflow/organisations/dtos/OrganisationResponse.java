package com.sorcererscode.fileflow.organisations.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationResponse {
    private Long id;
    private String name;
    private String address;
}
