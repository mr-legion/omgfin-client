package io.algostrategy.client.omgfin.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Asset description.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    private String symbol;
    private String name;

    private Boolean active;

    @JsonProperty("can_deposit")
    private Boolean depositEnabled;

    @JsonProperty("can_withdraw")
    private Boolean withdrawEnabled;

    @JsonProperty("cmcu_id")
    private String cmcuId;

    @JsonProperty("icon_path")
    private String iconPath;

    @JsonProperty("project_url")
    private String projectUrl;

    @JsonProperty("coin_description")
    private String coinDescription;
}