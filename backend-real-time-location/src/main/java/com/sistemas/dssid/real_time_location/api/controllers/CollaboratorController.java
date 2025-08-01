package com.sistemas.dssid.real_time_location.api.controllers;

import com.sistemas.dssid.real_time_location.models.dtos.CollaboratorDTO;
import com.sistemas.dssid.real_time_location.services.CollaboratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/collaborators")
public class CollaboratorController {

    private CollaboratorService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewRecord(@RequestBody CollaboratorDTO collaborator) {

        var conflict = service.hasCollaborator(collaborator);
        if(conflict) return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Já consta registro do colaborador de CPF" + collaborator.getCpf());

        var created = service.createNewRecord(collaborator);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody CollaboratorDTO collaborator) {
        var updated = service.update(id, collaborator);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") UUID id) {
       return ResponseEntity.ok().body(service.findByid(id));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CollaboratorDTO>> findAll(){
        var collaboradors = service.findAll();
        if (collaboradors.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(collaboradors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
