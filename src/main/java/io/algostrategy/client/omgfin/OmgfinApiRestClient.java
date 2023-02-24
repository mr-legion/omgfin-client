package io.algostrategy.client.omgfin;

import io.algostrategy.client.omgfin.domain.general.Asset;

import java.util.List;

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
}