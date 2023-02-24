package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.OmgfinApiRestClient;
import io.algostrategy.client.omgfin.domain.general.Asset;
import io.algostrategy.client.omgfin.domain.market.ExchangeInfo;

import java.util.List;

import static io.algostrategy.client.omgfin.impl.OmgfinApiServiceGenerator.executeSync;

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
        return executeSync(omgfinApiService.getAssets());
    }

    // Market endpoints

    @Override
    public ExchangeInfo getExchangeInfo() {
        return executeSync(omgfinApiService.getExchangeInfo());
    }
}
