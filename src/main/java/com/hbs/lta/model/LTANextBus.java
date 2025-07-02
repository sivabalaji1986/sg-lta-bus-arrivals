package com.hbs.lta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LTANextBus {

    @JsonIgnore
    @JsonProperty("OriginCode")
    private String OriginCode;

    @JsonIgnore
    @JsonProperty("DestinationCode")
    private String DestinationCode;

    @JsonProperty("EstimatedArrival")
    private String EstimatedArrival;

    @JsonIgnore
    @JsonProperty("Latitude")
    private String Latitude;

    @JsonIgnore
    @JsonProperty("Longitude")
    private String Longitude;

    @JsonProperty("VisitNumber")
    private String VisitNumber;

    @JsonProperty("Load")
    private String Load;

    @JsonProperty("Feature")
    private String Feature;

    @JsonProperty("Type")
    private String Type;

}
