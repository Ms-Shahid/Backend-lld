package org.backend.session.lld2.designpatterns.strategy.ridesharingapp;

import java.time.LocalTime;

public class SurgeRideSharing implements PricingStrategy{
    private static final double BASE_FARE = 5.0; // Base fare amount
    private static double SURGE_MULTIPLIER = 2.0; // Surge pricing multiplier

    @Override
    public PricingType supportsType() {
        return PricingType.SURGE;
    }

    // Calculate the surge multiplier based on the ride time
    public static double calculateSurgeMultiplier(LocalTime rideTime) {
        int hour = rideTime.getHour();
        if ((hour >= 7 && hour <= 9) || (hour >= 17 && hour <= 19)) {
            return SURGE_MULTIPLIER = SURGE_MULTIPLIER * 1.5; // Example multiplier for peak hours
        } else {
            return SURGE_MULTIPLIER;// No surge pricing during off-peak hours
        }
    }


    @Override
    public Double calculatePrice(RideDetails rideDetails) {

        return BASE_FARE * SURGE_MULTIPLIER;
    }
}
