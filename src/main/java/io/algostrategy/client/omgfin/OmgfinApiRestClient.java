package io.algostrategy.client.omgfin;

import io.algostrategy.client.omgfin.domain.general.Asset;
import io.algostrategy.client.omgfin.domain.market.ExchangeInfo;
import io.algostrategy.client.omgfin.domain.market.MarketTicker;

import java.util.List;
import java.util.Map;

/**
 * Omgfin API facade, supporting synchronous/blocking access Omgfin's REST API.
 */
public interface OmgfinApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    List<Asset> getAssets();

    // Market endpoints

    /**
     * Get market information.
     *
     * @return market info
     */
    ExchangeInfo getExchangeInfo();

    /**
     * Get market ticker information.
     *
     * @return market tickers
     */
    Map<String, MarketTicker> getMarketTickers();
}