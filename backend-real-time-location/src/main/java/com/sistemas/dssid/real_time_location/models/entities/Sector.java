package com.sistemas.dssid.real_time_location.models.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sector {

    @EqualsAndHashCode.Include
    private UUID id;

    private String number;

    private Group group;
}
