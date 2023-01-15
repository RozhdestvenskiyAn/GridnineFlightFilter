package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.MINUTES;

public class MoreTwoHoursGroundTimeFlightFilter implements FlightFilter {
    @Override
    public boolean doFilter(Flight flight) {
        long countGroundTime =0;
        if (flight.getSegments().size() > 1) {
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                LocalDateTime arrivalDate = flight.getSegments().get(i).getArrivalDate();
                LocalDateTime nextDepartureDate = flight.getSegments().get(i + 1).getDepartureDate();
                countGroundTime += MINUTES.between(arrivalDate, nextDepartureDate);
                if (countGroundTime>120){
                    return false;
                }
            }
        }
        return true;
    }
}
