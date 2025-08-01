package com.sistemas.dssid.real_time_location.repositories.queries;

public class QueriesCity {

    public static final String CITY_ALREADY_REGISTERED = "select count(city.id) > 0 from City city where city.name = :name and city.uf = :uf";
}
