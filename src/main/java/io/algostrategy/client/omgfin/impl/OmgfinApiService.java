package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.domain.general.Asset;
import io.algostrategy.client.omgfin.domain.market.ExchangeInfo;
import io.algostrategy.client.omgfin.domain.market.MarketTicker;
import io.algostrategy.client.omgfin.domain.market.OrderBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

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

    @GET("/api/v1/ticker/summary")
    Call<Map<String, MarketTicker>> getMarketTickers();

    @GET("/api/v1/orderbook/{market}")
    Call<OrderBook> getOrderBook(@Path("market") String market, @Query("limit") Integer limit);
}
