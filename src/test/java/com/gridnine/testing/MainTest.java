package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.FlightFilterService;
import com.gridnine.testing.filter.filterImpl.DepartingInPastFlightFilter;
import com.gridnine.testing.filter.filterImpl.DepartsBeforeArrivesFlightFilter;
import com.gridnine.testing.filter.filterImpl.MoreTwoHoursGroundTimeFlightFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class MainTest {
    List<Flight> flights = FlightBuilder.createFlights();
    FlightFilterService flightFilterService = new FlightFilterService();

    @Test
    void shouldBeFlightsAfterDepartingInPastFlightFilter() {
        List<FlightFilter> flightFilters = List.of(new DepartingInPastFlightFilter());
        List<Flight> result = flights.stream().filter(flight -> flightFilterService.doFilter(flight, flightFilters))
                .collect(Collectors.toList());

        Assertions.assertEquals(result.size(), flights.size() - 1);
    }

    @Test
    void shouldBeFlightsAfterDepartsBeforeArrivesFlightFilter() {
        List<FlightFilter> flightFilters = List.of(new DepartsBeforeArrivesFlightFilter());
        List<Flight> result = flights.stream().filter(flight -> flightFilterService.doFilter(flight, flightFilters))
                .collect(Collectors.toList());

        Assertions.assertEquals(result.size(), flights.size() - 1);
    }

    @Test
    void shouldBeFlightsAfterMoreTwoHoursGroundTimeFlightFilter() {
        List<FlightFilter> flightFilters = List.of(new MoreTwoHoursGroundTimeFlightFilter());
        List<Flight> result = flights.stream().filter(flight -> flightFilterService.doFilter(flight, flightFilters))
                .collect(Collectors.toList());

        Assertions.assertEquals(result.size(), flights.size() - 2);
    }

    @Test
    void shouldBeFlightsAfterAllFilters() {
        List<FlightFilter> flightFilters = List.of(new DepartingInPastFlightFilter(),
                new DepartsBeforeArrivesFlightFilter(),
                new MoreTwoHoursGroundTimeFlightFilter());
        List<Flight> result = flights.stream().filter(flight -> flightFilterService.doFilter(flight, flightFilters))
                .collect(Collectors.toList());

        Assertions.assertEquals(result.size(), flights.size() - 4);
    }
}
