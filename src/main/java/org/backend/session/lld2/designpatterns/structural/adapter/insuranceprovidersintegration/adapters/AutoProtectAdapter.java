package org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.adapters;

import org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.TravelInsuranceAdapter;
import org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.api.AutoProtectApi;

public class AutoProtectAdapter implements TravelInsuranceAdapter {

    private AutoProtectApi autoProtectApi = new AutoProtectApi();

    @Override
    public void submitClaim(String id, double amount) {
        Double wrapperAmount = Double.valueOf(amount);
        autoProtectApi.addClaim(wrapperAmount);
    }

    @Override
    public String getClaimStatus(String id) {
        return autoProtectApi.getStatus(id).toString();
    }

}
