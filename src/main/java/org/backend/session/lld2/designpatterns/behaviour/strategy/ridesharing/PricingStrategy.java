package org.backend.session.lld2.designpatterns.strategy.ridesharingapp;

public interface PricingStrategy {
    PricingType supportsType();
    Double calculatePrice(RideDetails rideDetails);

}
