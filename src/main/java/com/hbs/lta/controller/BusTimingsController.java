package com.hbs.lta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus-timings")
public class BusTimingsController {

    @GetMapping
    public boolean getBusStopTimings(@RequestParam(name = "busStopNo") int busStopNumber, @RequestParam(name = "busNo") int busNumber) {
        return true;
    }
}
