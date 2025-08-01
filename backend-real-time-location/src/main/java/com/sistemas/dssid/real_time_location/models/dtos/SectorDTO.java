package com.sistemas.dssid.real_time_location.models.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SectorDTO {
    
    @EqualsAndHashCode.Include
    private UUID id;

    private String number;

    private GroupDTO group;
}
