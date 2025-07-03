package com.hbs.lta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Bus service details with upcoming arrivals")
public class LTAService {

    @Schema(description = "Bus service number")
    @JsonProperty("ServiceNo")
    private String ServiceNo;

    @JsonIgnore
    @JsonProperty("Operator")
    private String Operator;

    @Schema(description = "Next arriving bus for the service")
    @JsonProperty("NextBus")
    private LTANextBus NextBus;

    @Schema(description = "Second arriving bus for the service")
    @JsonProperty("NextBus2")
    private LTANextBus NextBus2;

    @Schema(description = "Third arriving bus for the service")
    @JsonProperty("NextBus3")
    private LTANextBus NextBus3;
}
