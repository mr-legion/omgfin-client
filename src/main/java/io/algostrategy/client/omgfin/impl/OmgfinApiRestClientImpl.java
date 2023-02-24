package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.OmgfinApiRestClient;
import io.algostrategy.client.omgfin.domain.general.Asset;

import java.util.List;

/**
 * Implementation of Omgfin's REST API using Retrofit with synchronous/blocking method calls.
 */
public class OmgfinApiRestClientImpl implements OmgfinApiRestClient {

    private final OmgfinApiService omgfinApiService;

    public OmgfinApiRestClientImpl(OmgfinApiService omgfinApiService) {
        this.omgfinApiService = omgfinApiService;
    }

    // General endpoints

    @Override
    public List<Asset> getAssets() {
        return OmgfinApiServiceGenerator.executeSync(omgfinApiService.getAssets());
    }
}
