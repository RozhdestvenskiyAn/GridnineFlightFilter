package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;

public class DepartingInPastFlightFilter implements FlightFilter {
    @Override
    public boolean doFilter(Flight flight) {

        for (Segment segment: flight.getSegments()){
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())){
                return false;
            }
        }
        return true;
    }
}
