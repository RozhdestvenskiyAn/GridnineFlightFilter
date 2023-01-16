package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.FlightFilterService;
import com.gridnine.testing.filter.filterImpl.DepartingInPastFlightFilter;
import com.gridnine.testing.filter.filterImpl.DepartsBeforeArrivesFlightFilter;
import com.gridnine.testing.filter.filterImpl.MoreTwoHoursGroundTimeFlightFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static com.gridnine.testing.filter.FlightFilterService.*;

public class Main {
    public static void main(String[] args) {

        FlightFilterService flightFilterService = new FlightFilterService();

        System.out.println("Test flights:");
        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);

        System.out.println("Rule #1: departing in past flight");
        List<FlightFilter> filters1 = List.of(new DepartingInPastFlightFilter());

        flights.stream().filter(flight -> flightFilterService.doFilter(flight, filters1))
                .forEach(System.out::println);

        System.out.println("Rule #2: departs before arrives flight");
        List<FlightFilter> filters2 = List.of(new DepartsBeforeArrivesFlightFilter());

        flights.stream().filter(flight -> flightFilterService.doFilter(flight, filters2))
                .forEach(System.out::println);

        System.out.println("Rule #3: more two hours ground time flight");
        List<FlightFilter> filters3 = List.of(new MoreTwoHoursGroundTimeFlightFilter());

        flights.stream().filter(flight -> flightFilterService.doFilter(flight, filters3))
                .forEach(System.out::println);

        System.out.println("All rules: departing in past flight, departs before arrives flight, more two hours ground time flight");
        List<FlightFilter> allFilters = List.of(new DepartingInPastFlightFilter(),
                new DepartsBeforeArrivesFlightFilter(),
                new MoreTwoHoursGroundTimeFlightFilter());

        flights.stream().filter(flight -> flightFilterService.doFilter(flight, allFilters))
                .forEach(System.out::println);
    }
}
