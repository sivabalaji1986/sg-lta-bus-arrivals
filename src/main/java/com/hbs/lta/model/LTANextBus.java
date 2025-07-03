package com.hbs.lta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Bus arrival timing details")
public class LTANextBus {

    @JsonIgnore
    @JsonProperty("OriginCode")
    private String OriginCode;

    @JsonIgnore
    @JsonProperty("DestinationCode")
    private String DestinationCode;

    @Schema(description = "Estimated arrival time in ISO 8601 format")
    @JsonProperty("EstimatedArrival")
    private String EstimatedArrival;

    @JsonIgnore
    @JsonProperty("Latitude")
    private String Latitude;

    @JsonIgnore
    @JsonProperty("Longitude")
    private String Longitude;

    @Schema(description = "Visit number of the bus at this stop")
    @JsonProperty("VisitNumber")
    private String VisitNumber;

    @Schema(description = """
            Passenger load:
            - SEA: Seats Available
            - SDA: Standing Available
            - LSD: Limited Standing
            """)
    @JsonProperty("Load")
    private String Load;

    @Schema(description = """
            Bus feature:
            - WAB: Wheelchair Accessible Bus
            """)
    @JsonProperty("Feature")
    private String Feature;

    @Schema(description = """
            Bus type:
            - SD: Single Deck
            - DD: Double Deck
            """)
    @JsonProperty("Type")
    private String Type;

}
