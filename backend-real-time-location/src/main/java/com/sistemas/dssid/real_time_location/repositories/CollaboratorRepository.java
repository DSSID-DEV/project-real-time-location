package com.sistemas.dssid.real_time_location.repositories;

import com.sistemas.dssid.real_time_location.models.entities.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import static com.sistemas.dssid.real_time_location.repositories.queries.QueriesCollaborator.*;

@Repository
public interface CollaboratorRepository  extends JpaRepository<Collaborator, UUID> {


    @Query(value = COLLABORATER_ALREADY_REGISTERED)
    boolean collaboratorAlreadyRegistered(@Param("cpf") String cpf);

}
