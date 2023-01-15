package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;

public class DepartsBeforeArrivesFlightFilter implements FlightFilter {
    @Override
    public boolean doFilter(Flight flight) {

        if (flight.getSegments().size()==1){
            LocalDateTime departureDate = flight.getSegments().get(0).getDepartureDate();
            LocalDateTime arrivalDate = flight.getSegments().get(0).getArrivalDate();

            if (departureDate.isAfter(arrivalDate)){
                return false;
            }
        } else {
            for (int i = 0; i<flight.getSegments().size()-1;i++){
                LocalDateTime departureDate = flight.getSegments().get(i).getDepartureDate();
                LocalDateTime arrivalDate = flight.getSegments().get(i).getArrivalDate();
                LocalDateTime nextDepartureDate = flight.getSegments().get(i+1).getDepartureDate();

                if (departureDate.isAfter(arrivalDate) || arrivalDate.isAfter(nextDepartureDate)){
                    return false;
                }
            }
        }
        return true;
    }
}
