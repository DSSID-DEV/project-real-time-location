package com.sistemas.dssid.real_time_location.api.converters;


import com.sistemas.dssid.real_time_location.models.dtos.CollaboratorDTO;
import com.sistemas.dssid.real_time_location.models.entities.Collaborator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class CollaboratorConverters {

    private ModelMapper mapper;


    public Collaborator toEntity(CollaboratorDTO representationModel) {
        return mapper.map(representationModel, Collaborator.class);
    }

    public CollaboratorDTO toRepresentationModel(Collaborator entity) {
        return mapper.map(entity, CollaboratorDTO.class);
    }

}
