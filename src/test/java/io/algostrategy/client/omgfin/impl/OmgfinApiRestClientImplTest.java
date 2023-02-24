package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.OmgfinApiClientFactory;
import io.algostrategy.client.omgfin.OmgfinApiRestClient;
import io.algostrategy.client.omgfin.domain.general.Asset;
import io.algostrategy.client.omgfin.domain.market.ExchangeInfo;
import io.algostrategy.client.omgfin.domain.market.MarketTicker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OmgfinApiRestClientImplTest {

    private final OmgfinApiRestClient omgfinApiRestClient = OmgfinApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        List<Asset> assets = omgfinApiRestClient.getAssets();
        assertThat(assets, is(not(empty())));
    }

    @Test
    public void getExchangeInfo_ShouldReturnExchangeInfo() {
        ExchangeInfo exchangeInfo = omgfinApiRestClient.getExchangeInfo();
        assertNotNull(exchangeInfo);
        assertThat(exchangeInfo.getMarkets(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        Map<String, MarketTicker> marketTickers = omgfinApiRestClient.getMarketTickers();
        assertThat(marketTickers, allOf(notNullValue(), is(not(anEmptyMap()))));
    }
}