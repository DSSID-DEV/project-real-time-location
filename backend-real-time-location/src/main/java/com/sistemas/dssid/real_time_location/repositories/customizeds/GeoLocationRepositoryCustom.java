package com.sistemas.dssid.real_time_location.repositories.customizeds;

import com.sistemas.dssid.real_time_location.models.dtos.responses.CollaboratorLastLocation;
import com.sistemas.dssid.real_time_location.models.entities.Collaborator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoLocationRepositoryCustom {

    List<CollaboratorLastLocation> listLastLocationOfCollaborators();

    CollaboratorLastLocation lastLocationOfCollaborators(Collaborator collaborator);
}
