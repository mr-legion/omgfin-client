package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.OmgfinApiAsyncRestClient;
import io.algostrategy.client.omgfin.OmgfinApiClientFactory;
import io.algostrategy.client.omgfin.domain.general.Asset;
import io.algostrategy.client.omgfin.domain.market.ExchangeInfo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OmgfinApiAsyncRestClientImplTest {

    private final OmgfinApiAsyncRestClient omgfinApiAsyncRestClient = OmgfinApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        List<Asset> assets = omgfinApiAsyncRestClient.getAssets().get();
        assertThat(assets, is(not(empty())));
    }

    @Test
    public void getExchangeInfo_ShouldReturnExchangeInfo() throws ExecutionException, InterruptedException {
        ExchangeInfo exchangeInfo = omgfinApiAsyncRestClient.getExchangeInfo().get();
        assertNotNull(exchangeInfo);
        assertThat(exchangeInfo.getMarkets(), is(not(empty())));
    }
}