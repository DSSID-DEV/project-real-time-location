package com.sistemas.dssid.real_time_location.models.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GeoLocationDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private LocalDate date;

    private LocalTime time;

}
