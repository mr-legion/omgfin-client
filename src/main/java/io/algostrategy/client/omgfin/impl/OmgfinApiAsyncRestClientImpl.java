package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.OmgfinApiAsyncRestClient;
import io.algostrategy.client.omgfin.domain.general.Asset;
import io.algostrategy.client.omgfin.domain.market.ExchangeInfo;
import io.algostrategy.client.omgfin.domain.market.MarketTicker;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Omgfin's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class OmgfinApiAsyncRestClientImpl implements OmgfinApiAsyncRestClient {

    private final OmgfinApiService omgfinApiService;

    public OmgfinApiAsyncRestClientImpl(OmgfinApiService omgfinApiService) {
        this.omgfinApiService = omgfinApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<List<Asset>> getAssets() {
        CompletableFuture<List<Asset>> future = new CompletableFuture<>();
        omgfinApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Market endpoints

    @Override
    public CompletableFuture<ExchangeInfo> getExchangeInfo() {
        CompletableFuture<ExchangeInfo> future = new CompletableFuture<>();
        omgfinApiService.getExchangeInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Map<String, MarketTicker>> getMarketTickers() {
        CompletableFuture<Map<String, MarketTicker>> future = new CompletableFuture<>();
        omgfinApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
