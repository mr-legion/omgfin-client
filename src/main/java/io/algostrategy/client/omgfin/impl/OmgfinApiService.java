package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.domain.general.Asset;
import io.algostrategy.client.omgfin.domain.market.ExchangeInfo;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Omgfin's REST API URL mappings.
 */
public interface OmgfinApiService {

    // General endpoints

    @GET("/api/v1/coinInfo")
    Call<List<Asset>> getAssets();

    // Market data endpoints

    @GET("/api/v1/exchangeInfo")
    Call<ExchangeInfo> getExchangeInfo();
}
