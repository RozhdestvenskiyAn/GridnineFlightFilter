package com.gridnine.testing.filter;

import com.gridnine.testing.filter.impl.DepartingInPastFlightFilter;
import com.gridnine.testing.filter.impl.DepartsBeforeArrivesFlightFilter;
import com.gridnine.testing.filter.impl.MoreTwoHoursGroundTimeFlightFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterBuilder {
    public static List<FlightFilter> flightFilters = new ArrayList<>();

    public static List<FlightFilter> getFlightFilters() {
        flightFilters.add(new DepartingInPastFlightFilter());
        flightFilters.add(new DepartsBeforeArrivesFlightFilter());
        flightFilters.add(new MoreTwoHoursGroundTimeFlightFilter());
        return flightFilters;
    }
}
