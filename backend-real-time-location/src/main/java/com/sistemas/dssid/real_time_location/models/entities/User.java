package com.sistemas.dssid.real_time_location.models.entities;


import com.sistemas.dssid.real_time_location.models.enums.Permission;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    private UUID id;

    private String username;

    private String password;

    private String oldPassword;

    private Permission permission;


}
