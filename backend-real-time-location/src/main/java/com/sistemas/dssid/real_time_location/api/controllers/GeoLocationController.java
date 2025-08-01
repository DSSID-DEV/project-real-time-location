package com.sistemas.dssid.real_time_location.api.controllers;

import com.sistemas.dssid.real_time_location.models.dtos.responses.CollaboratorLastLocation;
import com.sistemas.dssid.real_time_location.services.GeoLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locations")
public class GeoLocationController {

    private GeoLocationService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CollaboratorLastLocation>> getLastLocation() {
        var lastLocations = service.listLastLocationOfCollaborators();
        if(lastLocations.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lastLocations);
    }

    @GetMapping(value = "/last-location/do/{collaboratorId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CollaboratorLastLocation> lastLocationOfCollaborator(@PathVariable("collaboratorId") UUID collaboratorId) {
        var lastLocation = service.lastLocationOfCollaborators(collaboratorId);
        return ResponseEntity.ok(lastLocation);
    }

    @GetMapping(value = "/list-location/do/{collaboratorId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CollaboratorLastLocation> listLocationOfCollaborator(@PathVariable("collaboratorId") UUID collaboratorId) {
        var lastLocation = service.listLocationOfCollaborator(collaboratorId);
        return ResponseEntity.ok(lastLocation);
    }

    @GetMapping(value = "/location/do/{collaboratorId}/between-dates", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CollaboratorLastLocation> listLocationCollaboratorBetweenDates(@PathVariable("collaboratorId") UUID collaboratorId,
                                                                                         @RequestParam("fromDate") LocalDate fromDate,
                                                                                         @RequestParam("toDate") LocalDate toDate) {
        var lastLocation = service.listLocationCollaboratorBetweenDates(collaboratorId, fromDate, toDate);
        return ResponseEntity.ok(lastLocation);
    }
}
