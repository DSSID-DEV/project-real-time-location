package com.sistemas.dssid.real_time_location.api.converters;

import com.sistemas.dssid.real_time_location.models.dtos.CityDTO;
import com.sistemas.dssid.real_time_location.models.entities.City;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class CityConverters {

    private ModelMapper mapper;

    public City toEntity(CityDTO city) {
        return mapper.map(city, City.class);
    }

    public CityDTO toRepresentationModel(City saved) {
        return mapper.map(saved, CityDTO.class);
    }
}
