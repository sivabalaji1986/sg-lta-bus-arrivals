package com.hbs.lta.controller;

import com.hbs.lta.model.LTABusStopResponse;
import com.hbs.lta.service.LTABusTimingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus-arrivals")
@Tag(name = "Bus Arrivals", description = "Get real-time bus timings")
public class BusTimingsController {

    private LTABusTimingService ltaBusTimingService;

    public BusTimingsController(LTABusTimingService ltaBusTimingService) {
        this.ltaBusTimingService = ltaBusTimingService;
    }

    @Operation(summary = "Get bus timings by stop and service number")
    @GetMapping
    public ResponseEntity<LTABusStopResponse> getBusStopTimings(
            @RequestParam(name = "busStopCode") int busStopCode, @RequestParam(name = "serviceNo") String serviceNo) {
        LTABusStopResponse response = ltaBusTimingService.getBusStopTimings(busStopCode, serviceNo);
        return response != null
                ? ResponseEntity.ok(response)
                : ResponseEntity.notFound().build();
    }
}
