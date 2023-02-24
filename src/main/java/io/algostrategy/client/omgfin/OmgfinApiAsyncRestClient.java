package io.algostrategy.client.omgfin;

import io.algostrategy.client.omgfin.domain.general.Asset;

import java.util.List;
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
}