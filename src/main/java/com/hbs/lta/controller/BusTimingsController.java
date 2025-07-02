package com.hbs.lta.controller;

import com.hbs.lta.model.LTABusStopResponse;
import com.hbs.lta.service.LTABusTimingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus-timings")
public class BusTimingsController {

    private LTABusTimingService ltaBusTimingService;

    public BusTimingsController(LTABusTimingService ltaBusTimingService) {
        this.ltaBusTimingService = ltaBusTimingService;
    }

    @GetMapping
    public LTABusStopResponse getBusStopTimings(@RequestParam(name = "busStopNo") int busStopNumber, @RequestParam(name = "busNo") int busNumber) {
        return ltaBusTimingService.getBusStopTimings(busStopNumber, busNumber);
    }
}
