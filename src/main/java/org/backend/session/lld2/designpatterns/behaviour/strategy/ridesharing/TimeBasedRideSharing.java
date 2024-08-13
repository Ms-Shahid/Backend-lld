package org.backend.session.lld2.designpatterns.strategy.ridesharingapp;

public class TimeBasedRideSharing implements PricingStrategy{

    private static final double BASE_FARE = 5.0; // Base fare amount
    private static final double PER_MINUTE_RATE = 0.5; // Rate per minute

    @Override
    public PricingType supportsType() {
        return PricingType.TIME_BASED;
    }

    @Override
    public Double calculatePrice(RideDetails rideDetails) {
        return BASE_FARE + PER_MINUTE_RATE * rideDetails.getDuration();
    }
}
