package com.hbs.lta.controller;

import com.hbs.lta.model.LTABusStopResponse;
import com.hbs.lta.service.LTABusTimingService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BusTimingsControllerTest {

    @Test
    void shouldReturnBusStopResponseWhenValidParams() {
        LTABusTimingService mockService = mock(LTABusTimingService.class);
        BusTimingsController controller = new BusTimingsController(mockService);

        LTABusStopResponse dummyResponse = new LTABusStopResponse();
        when(mockService.getBusStopTimings(96129, "12")).thenReturn(dummyResponse);

        ResponseEntity<LTABusStopResponse> response = controller.getBusStopTimings(96129, "12");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dummyResponse, response.getBody());
    }
}