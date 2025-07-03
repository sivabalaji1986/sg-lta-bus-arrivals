package com.hbs.lta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response containing real-time arrival info for a specific bus stop")
public class LTABusStopResponse {

    @JsonIgnore
    @JsonProperty("odata.metadata")
    private String metaData;

    @Schema(description = "Bus stop code")
    @JsonProperty("BusStopCode")
    private String BusStopCode;

    @Schema(description = "List of available bus services at this stop")
    @JsonProperty("Services")
    private LTAService[] Services;
}
