package com.hbs.lta.service;

import com.hbs.lta.gateway.LTAGateway;
import com.hbs.lta.model.LTABusStopResponse;
import com.hbs.lta.model.LTANextBus;
import com.hbs.lta.model.LTAService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LTABusTimingServiceTest {

    @Test
    void shouldCallGatewayAndReturnResponse() {
        LTAGateway mockGateway = mock(LTAGateway.class);
        LTABusTimingService service = new LTABusTimingService(mockGateway);

        LTABusStopResponse mockResponse = new LTABusStopResponse();
        when(mockGateway.getBusTimingsInBusStop(96129, "12")).thenReturn(mockResponse);

        LTABusStopResponse result = service.getBusStopTimings(96129, "12");

        assertEquals(mockResponse, result);
    }

    @Test
    void shouldNullifyNextBusFieldsWhenVisitNumberIsBlank() {
        LTAGateway mockGateway = mock(LTAGateway.class);
        LTABusTimingService service = new LTABusTimingService(mockGateway);

        // Create dummy NextBus entries with blank visit numbers
        LTANextBus bus1 = new LTANextBus();
        bus1.setVisitNumber(""); // Blank → should trigger nullification

        LTANextBus bus2 = new LTANextBus();
        bus2.setVisitNumber(" "); // Also blank

        LTANextBus bus3 = new LTANextBus();
        bus3.setVisitNumber(" "); // null

        LTAService ltaService = new LTAService();
        ltaService.setServiceNo("12");
        ltaService.setNextBus(bus1);
        ltaService.setNextBus2(bus2);
        ltaService.setNextBus3(bus3);

        LTABusStopResponse response = new LTABusStopResponse();
        response.setBusStopCode("96129");
        response.setServices(new LTAService[]{ltaService});

        when(mockGateway.getBusTimingsInBusStop(96129, "12")).thenReturn(response);

        // Act
        LTABusStopResponse result = service.getBusStopTimings(96129, "12");

        // Assert
        assertNull(result.getServices()[0].getNextBus(), "NextBus should be null");
        assertNull(result.getServices()[0].getNextBus2(), "NextBus2 should be null");
        assertNull(result.getServices()[0].getNextBus3(), "NextBus3 should be null");
    }

}
