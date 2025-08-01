package com.sistemas.dssid.real_time_location.repositories;

import com.sistemas.dssid.real_time_location.models.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository  extends JpaRepository<City, UUID> {
}
