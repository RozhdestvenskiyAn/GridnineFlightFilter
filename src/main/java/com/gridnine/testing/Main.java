package com.gridnine.testing;

import com.gridnine.testing.filter.FilterBuilder;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);

        FilterBuilder.getFlightFilters().stream()
                .peek(flightFilter -> System.out.println("-------------"))
                .flatMap(filter -> flights.stream().filter(filter::doFilter))
                .forEach(System.out::println);
    }
}
