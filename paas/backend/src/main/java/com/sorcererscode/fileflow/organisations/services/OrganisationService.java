package com.sorcererscode.fileflow.organisations.services;

import com.sorcererscode.fileflow.organisations.dtos.OrganisationInput;
import com.sorcererscode.fileflow.organisations.dtos.OrganisationResponse;
import com.sorcererscode.fileflow.users.User;

import java.util.List;

public interface OrganisationService {

    OrganisationResponse create(OrganisationInput input, User maintainer);

    OrganisationResponse get(long id);

    List<OrganisationResponse> getAll(int page, int limit);

    List<OrganisationResponse> getUserOrganisations(User maintainer, int page, int limit);

    OrganisationResponse update(long id, OrganisationInput input);
}
