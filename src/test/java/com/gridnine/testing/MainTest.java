package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.impl.DepartingInPastFlightFilter;
import com.gridnine.testing.filter.impl.DepartsBeforeArrivesFlightFilter;
import com.gridnine.testing.filter.impl.MoreTwoHoursGroundTimeFlightFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class MainTest {
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    void shouldBeFlightsAfterDepartingInPastFlightFilter() {
        FlightFilter flightFilter = new DepartingInPastFlightFilter();
        List<Flight> result = flights.stream().filter(flightFilter::doFilter).collect(Collectors.toList());

        Assertions.assertEquals(result.size(), flights.size()-1);
    }

    @Test
    void shouldBeFlightsAfterDepartsBeforeArrivesFlightFilter() {
        FlightFilter flightFilter = new DepartsBeforeArrivesFlightFilter();
        List<Flight> result = flights.stream().filter(flightFilter::doFilter).collect(Collectors.toList());

        Assertions.assertEquals(result.size(), flights.size()-1);
    }

    @Test
    void shouldBeFlightsAfterMoreTwoHoursGroundTimeFlightFilter() {
        FlightFilter flightFilter = new MoreTwoHoursGroundTimeFlightFilter();
        List<Flight> result = flights.stream().filter(flightFilter::doFilter).collect(Collectors.toList());

        Assertions.assertEquals(result.size(), flights.size()-2);
    }
}
