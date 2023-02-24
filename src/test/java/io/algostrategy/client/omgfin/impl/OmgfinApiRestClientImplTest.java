package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.OmgfinApiClientFactory;
import io.algostrategy.client.omgfin.OmgfinApiRestClient;
import io.algostrategy.client.omgfin.domain.general.Asset;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OmgfinApiRestClientImplTest {

    private final OmgfinApiRestClient omgfinApiRestClient = OmgfinApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        List<Asset> assets = omgfinApiRestClient.getAssets();
        assertThat(assets, is(not(empty())));
    }
}