package com.sistemas.dssid.real_time_location.repositories;

import com.sistemas.dssid.real_time_location.models.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.sistemas.dssid.real_time_location.repositories.queries.QueriesCity.*;

@Repository
public interface CityRepository  extends JpaRepository<City, UUID> {

    @Query(value = CITY_ALREADY_REGISTERED)
    boolean cityAlreadyRegistered(@Param("name") String name, @Param("uf") String uf);
}
