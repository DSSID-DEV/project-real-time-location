package com.sistemas.dssid.real_time_location.models.dtos.responses;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CollaboratorLastLocation {

    private String name;
    private String cpf;
    private String avatar;
    private String smartphone;

    private LocalDate dateOfRegistion;

    private LocalTime timeOfRegistrion;

    private LatLng latLng;


    public void getFirstNameAndLastName(String name) {
        var firstName = name.split(" ")[0] + " ";
        var lastIndex = name.lastIndexOf(" ");
        var firstAndLastName = firstName.concat(name.substring(lastIndex));
        setName(firstAndLastName);
    }

}
