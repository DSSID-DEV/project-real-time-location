package com.sistemas.dssid.real_time_location.models.dtos.responses;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class LatLng {
    private BigDecimal latitude;

    private BigDecimal longitude;
}
