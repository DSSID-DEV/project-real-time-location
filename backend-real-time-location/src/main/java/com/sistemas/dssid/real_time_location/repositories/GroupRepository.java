package com.sistemas.dssid.real_time_location.repositories;

import com.sistemas.dssid.real_time_location.models.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository  extends JpaRepository<Group, UUID> {
}
