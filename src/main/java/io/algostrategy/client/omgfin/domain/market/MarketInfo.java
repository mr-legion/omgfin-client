package io.algostrategy.client.omgfin.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    private String symbol;

    private String baseAsset;
    private String quoteAsset;

    private MarketStatus status;

    private Integer baseAssetPrecision;
    private Integer quotePrecision;

    private List<String> orderTypes;
}
