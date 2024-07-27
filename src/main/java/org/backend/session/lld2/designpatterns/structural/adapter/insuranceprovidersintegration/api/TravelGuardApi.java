package org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.api;

import org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.AppUtils;

public class TravelGuardApi {
    public void submitClaim(String id, Double amount) {
        AppUtils.logTravelGuardClaimCall();
    }

    public String getClaimStatus(String id) {
        AppUtils();
        return "SUCCESS";
    }
}
