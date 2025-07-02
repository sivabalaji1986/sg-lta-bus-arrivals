package com.hbs.lta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LTABusStopResponse {

    @JsonIgnore
    @JsonProperty("odata.metadata")
    private String metaData;

    @JsonProperty("BusStopCode")
    private String BusStopCode;

    @JsonProperty("Services")
    private LTAService[] Services;

}
