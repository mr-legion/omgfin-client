package io.algostrategy.client.omgfin.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Market status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketStatus {
    TRADING
}
