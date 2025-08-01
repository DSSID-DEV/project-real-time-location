package com.sistemas.dssid.real_time_location.services;

import com.sistemas.dssid.real_time_location.models.dtos.responses.CollaboratorLastLocation;
import com.sistemas.dssid.real_time_location.repositories.GeoLocationRepository;
import com.sistemas.dssid.real_time_location.repositories.customizeds.GeoLocationRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GeoLocationService {

    private GeoLocationRepository repository;
    private GeoLocationRepositoryCustom repositoryCustom;
    private CollaboratorService collaboratorService;

    public List<CollaboratorLastLocation> listLastLocationOfCollaborators() {

        return repositoryCustom.listLastLocationOfCollaborators();
    }

    public CollaboratorLastLocation lastLocationOfCollaborators(UUID collaboratorId) {

        var collaborator = collaboratorService.findOrFail(collaboratorId);

        return repositoryCustom.lastLocationOfCollaborators(collaborator);
    }

    public CollaboratorLastLocation listLocationCollaboratorBetweenDates(UUID collaboratorId, LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    public CollaboratorLastLocation listLocationOfCollaborator(UUID collaboratorId) {
        return null;
    }
}
