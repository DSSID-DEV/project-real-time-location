package com.sistemas.dssid.real_time_location.models.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SmartphoneDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7020265083797034398L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String ddd;

    private String number;

    private String imei1;

    private String imei2;

    private CollaboratorDTO collaborator;
}
