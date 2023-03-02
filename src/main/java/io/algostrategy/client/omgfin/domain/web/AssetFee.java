package io.algostrategy.client.omgfin.domain.web;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Asset fee information.
 */
@Data
@AllArgsConstructor
public class AssetFee {
    private String assetSymbol;
    private Double withdrawFee;
}
