package com.sorcererscode.fileflow.organisations.services;

import com.sorcererscode.fileflow.organisations.db.Organisation;
import com.sorcererscode.fileflow.organisations.db.OrganisationRepository;
import com.sorcererscode.fileflow.organisations.dtos.OrganisationInput;
import com.sorcererscode.fileflow.organisations.dtos.OrganisationResponse;
import com.sorcererscode.fileflow.users.User;
import com.sorcererscode.fileflow.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrganisationServiceImpl implements OrganisationService{

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrganisationResponse create(OrganisationInput input, User maintainer) {
        Organisation organisation = modelMapper.map(input, Organisation.class);

        organisation.setMaintainer(maintainer);

        organisationRepository.save(organisation);

        return modelMapper.map(organisation, OrganisationResponse.class);
    }

    @Override
    public OrganisationResponse get(long id) {
        Organisation organisation = organisationRepository.getReferenceById(id);
        return modelMapper.map(organisation, OrganisationResponse.class);
    }

    @Override
    public List<OrganisationResponse> getAll(int page, int limit) {
        return null;
    }

    @Override
    public List<OrganisationResponse> getUserOrganisations(User maintainer, int page, int limit) {

        List<Organisation> userOrganisations = organisationRepository.findByMaintainer(
                maintainer,
                PageRequest.of(page - 1, limit)
        );

        return userOrganisations.stream().map(org -> modelMapper.map(org, OrganisationResponse.class))
                .toList();
    }

    @Override
    public OrganisationResponse update(long id, OrganisationInput input) {
        return null;
    }
}
