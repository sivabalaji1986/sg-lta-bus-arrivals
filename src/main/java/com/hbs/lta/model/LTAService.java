package com.hbs.lta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LTAService {

    @JsonProperty("ServiceNo")
    private String ServiceNo;

    @JsonIgnore
    @JsonProperty("Operator")
    private String Operator;

    @JsonProperty("NextBus")
    private LTANextBus NextBus;

    @JsonProperty("NextBus2")
    private LTANextBus NextBus2;

    @JsonProperty("NextBus3")
    private LTANextBus NextBus3;

}
