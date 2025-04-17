package com.dk.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import com.dk.organizationservice.dto.OrganizationDto;
import com.dk.organizationservice.entity.Organization;
import com.dk.organizationservice.repository.OrganizationRepository;
import com.dk.organizationservice.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    private ModelMapper mapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = mapper.map(organizationDto,Organization.class);

        Organization savedOrganization = organizationRepository.save(organization);

        return mapper.map(savedOrganization,OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return mapper.map(organization,OrganizationDto.class);
    }
}
