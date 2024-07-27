package org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.api;

import org.backend.session.lld2.designpatterns.adapter.insuranceprovidersintegration.AppUtils;

public class AutoProtectApi {
    public void addClaim(Double amount) {
        AppUtils.logAutoProtectClaimCall();
    }

    public AutoProtectStatus getStatus(String id) {
        AppUtils();
        return AutoProtectStatus.APPROVED;
    }
}
