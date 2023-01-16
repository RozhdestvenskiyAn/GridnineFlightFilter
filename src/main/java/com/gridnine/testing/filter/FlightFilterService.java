package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;

public class FlightFilterService {

    public boolean doFilter(Flight flight, List <FlightFilter> flightFilters){
        return flightFilters.stream().allMatch(flightFilter -> flightFilter.doFilter(flight));
    }

}
