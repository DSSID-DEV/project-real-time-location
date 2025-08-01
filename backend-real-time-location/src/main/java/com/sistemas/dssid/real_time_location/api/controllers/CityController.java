package com.sistemas.dssid.real_time_location.api.controllers;


import com.sistemas.dssid.real_time_location.api.converters.CityConverters;
import com.sistemas.dssid.real_time_location.models.dtos.CityDTO;
import com.sistemas.dssid.real_time_location.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

    private CityConverters converter;

    private CityService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewRecord(@RequestBody CityDTO city) {
        var conflict = service.hasRecord(city);
        if(conflict) return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Já consta esta cidade em nossos registros");

        var cityCreated = service.createNewRecord(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(cityCreated);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody CityDTO city) {
        var optional = service.findById(id);
        if(!optional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não há registro de cidade para com o parâmetro informado");

        var updated = service.updateCity(id, city);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") UUID id) {
        var optional = service.findById(id);
        if(!optional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Já consta esta cidade em nossos registros");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(converter.toRepresentationModel(optional.get()));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDTO>> findAll() {
        var content = service.findAll();
        if (content.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(content);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        var optional = service.findById(id);
        if(!optional.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Já consta esta cidade em nossos registros");
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
