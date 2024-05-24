package com.sorcererscode.fileflow.organisations;

import com.sorcererscode.fileflow.organisations.services.OrganisationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/organisations")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

}
