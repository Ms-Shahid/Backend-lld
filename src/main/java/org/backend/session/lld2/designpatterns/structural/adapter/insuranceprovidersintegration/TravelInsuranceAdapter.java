package org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration;

public interface TravelInsuranceAdapter {

    void submitClaim(String id, double amount);

    String getClaimStatus(String id);
}
