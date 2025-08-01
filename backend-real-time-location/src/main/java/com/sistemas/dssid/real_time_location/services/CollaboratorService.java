package com.sistemas.dssid.real_time_location.services;

import com.sistemas.dssid.real_time_location.api.converters.CollaboratorConverters;
import com.sistemas.dssid.real_time_location.models.dtos.CollaboratorDTO;
import com.sistemas.dssid.real_time_location.models.entities.Collaborator;
import com.sistemas.dssid.real_time_location.repositories.CollaboratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollaboratorService {
    private CollaboratorConverters converter;
    private CollaboratorRepository repository;

    public CollaboratorDTO createNewRecord(CollaboratorDTO collaborator) {

        var entity = converter.toEntity(collaborator);
        var created = repository.save(entity);
        repository.flush();
        return converter.toRepresentationModel(created);

    }

    @Transactional
    public CollaboratorDTO update(UUID id, CollaboratorDTO collaborator) {
        var entity = findOrFail(id);
        entity.setCpf(collaborator.getCpf());
        entity.setName(collaborator.getName());
        entity.setRegistration(collaborator.getRegistration());
        var updated = repository.save(entity);
        repository.flush();
        return converter.toRepresentationModel(updated);
    }

    public CollaboratorDTO findByid(UUID id) {
        var entity = findOrFail(id);
        return converter.toRepresentationModel(entity);
    }

    public List<CollaboratorDTO> findAll() {
        var collaborators = repository.findAll();

        if(!collaborators.isEmpty()) {
            return List.of();
        }
        return collaborators.stream()
                .map(collaborator -> converter.toRepresentationModel(collaborator))
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        findOrFail(id);
        repository.deleteById(id);
    }

    //TODO: CRIAR CLASSE DE EXCEPTION
    public Collaborator findOrFail(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Criar classe de Exception"));
    }


    public boolean hasCollaborator(CollaboratorDTO collaborator) {
        return repository.collaboratorAlreadyRegistered(collaborator.getCpf());
    }
}
