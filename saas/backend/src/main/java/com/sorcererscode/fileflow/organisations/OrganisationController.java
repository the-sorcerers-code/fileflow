package com.sorcererscode.fileflow.organisations;

import com.sorcererscode.fileflow.common.models.Result;
import com.sorcererscode.fileflow.organisations.dtos.OrganisationInput;
import com.sorcererscode.fileflow.organisations.dtos.OrganisationResponse;
import com.sorcererscode.fileflow.organisations.services.OrganisationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/organisations")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;


    @PostMapping
    public ResponseEntity<Result<OrganisationResponse>> createOrganisation(
            @RequestBody OrganisationInput input) {
        OrganisationResponse organisationDetails = organisationService.create(input);
        Result<OrganisationResponse> responseBody = new Result<>();
        responseBody.setSuccess(false);
        responseBody.setData(organisationDetails);

        return ResponseEntity.ok(responseBody);
    }

}
