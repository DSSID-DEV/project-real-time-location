package com.sistemas.dssid.real_time_location.services;

import com.sistemas.dssid.real_time_location.api.converters.CityConverters;
import com.sistemas.dssid.real_time_location.models.dtos.CityDTO;
import com.sistemas.dssid.real_time_location.models.entities.City;
import com.sistemas.dssid.real_time_location.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private CityConverters converter;
    private CityRepository repository;

    public CityDTO createNewRecord(CityDTO city) {
        var entity = converter.toEntity(city);
        var created = repository.save(entity);
        repository.flush();
       return converter.toRepresentationModel(created);
    }

    public CityDTO updateCity(UUID id, CityDTO city) {
        var entity = findById(id).get();
        entity.setUf(city.getUf());
        entity.setName(city.getName());
        var updated = repository.save(entity);
        repository.flush();
        return converter.toRepresentationModel(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public List<CityDTO> findAll() {
        var cities = repository.findAll();
        if (cities.isEmpty()) return List.of();
        return cities.stream().map(city -> converter.toRepresentationModel(city))
                .collect(Collectors.toList());
    }

    public Optional<City> findById(UUID id) {
        return repository.findById(id);
    }

    public boolean hasRecord(CityDTO city) {
        return repository.cityAlreadyRegistered(city.getName(), city.getUf());
    }

}
