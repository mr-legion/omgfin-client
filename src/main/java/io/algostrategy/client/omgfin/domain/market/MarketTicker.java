package io.algostrategy.client.omgfin.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private Double last;

    @JsonProperty("lowestAsk")
    private Double ask;

    @JsonProperty("highestBid")
    private Double bid;

    private Double percentChange;

    private Double baseVolume;
    private Double quoteVolume;

    private Double low24hr;
    private Double high24hr;
}
