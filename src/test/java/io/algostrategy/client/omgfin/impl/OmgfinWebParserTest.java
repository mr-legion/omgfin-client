package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.domain.web.AssetFee;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class OmgfinWebParserTest {

    private final OmgfinWebParser omgfinWebParser = new OmgfinWebParser(new OkHttpClient());

    @Test
    public void parseAssetFees_ShouldReturnAssetFees() {
        List<AssetFee> assetFees = omgfinWebParser.parseAssetFees();
        assertThat(assetFees, notNullValue());
    }
}