package io.algostrategy.client.omgfin;

import io.algostrategy.client.omgfin.domain.general.Asset;
import io.algostrategy.client.omgfin.domain.market.ExchangeInfo;
import io.algostrategy.client.omgfin.domain.market.MarketTicker;
import io.algostrategy.client.omgfin.domain.market.OrderBook;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Omgfin API facade, supporting asynchronous/non-blocking access Omgfin's REST API.
 */
public interface OmgfinApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<List<Asset>> getAssets();

    // Market endpoints

    /**
     * Get market information (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<ExchangeInfo> getExchangeInfo();

    /**
     * Get market ticker information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Map<String, MarketTicker>> getMarketTickers();

    /**
     * Get order book for the market (asynchronous).
     *
     * @param market market symbol (e.g. ETH_BTC)
     * @param limit  depth of the order book. Valid limits: [5, 10, 20, 50, 100, 500]
     * @return order book
     */
    CompletableFuture<OrderBook> getOrderBook(String market, Integer limit);
}