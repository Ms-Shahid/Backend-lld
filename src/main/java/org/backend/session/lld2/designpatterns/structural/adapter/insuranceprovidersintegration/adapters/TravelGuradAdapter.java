package org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.adapters;

import org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.TravelInsuranceAdapter;
import org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.api.TravelGuardApi;

public class TravelGuardAdapter implements TravelInsuranceAdapter {

    //the api/third party instance
    private TravelGuardApi travelGuardApi = new TravelGuardApi();


    @Override
    public void submitClaim(String id, double amount) {
        travelGuardApi.submitClaim(id, amount);
    }

    @Override
    public String getClaimStatus(String id) {
        return travelGuardApi.getClaimStatus(id);
    }


}
