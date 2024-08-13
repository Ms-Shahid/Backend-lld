package org.backend.session.lld2.designpatterns.strategy.ridesharingapp;


import lombok.Getter;
import lombok.Setter;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class RideDetails {
    private double distance; // Distance in kilometers
    private int duration; // Duration in minutes
    private TimeUnit timeUnit;
}
