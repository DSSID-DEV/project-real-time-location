package com.sistemas.dssid.real_time_location.repositories.customizeds.implementations;

import com.sistemas.dssid.real_time_location.models.dtos.responses.CollaboratorLastLocation;
import com.sistemas.dssid.real_time_location.models.entities.Collaborator;
import com.sistemas.dssid.real_time_location.repositories.customizeds.GeoLocationRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.sistemas.dssid.real_time_location.repositories.queries.QueryGeoLocation.*;

@Repository
@RequiredArgsConstructor
public class GeoLocationRepositoryImpl implements GeoLocationRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CollaboratorLastLocation> listLastLocationOfCollaborators() {
        Query q = entityManager.createNativeQuery(LIST_LAST_LOCATION_OF_COLLABORATORS);
        return List.of();
    }

    @Override
    public CollaboratorLastLocation lastLocationOfCollaborators(Collaborator collaborator) {
        Query q = entityManager.createNativeQuery(LAST_LOCATION_OF_COLLABORATORS);
        return (CollaboratorLastLocation) q.getSingleResult();
    }
}
