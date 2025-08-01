package com.sistemas.dssid.real_time_location.models.dtos;


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
public class UserDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    private String username;

    private String password;

    private String OldPassowrd;

    private Permission permission;
}
