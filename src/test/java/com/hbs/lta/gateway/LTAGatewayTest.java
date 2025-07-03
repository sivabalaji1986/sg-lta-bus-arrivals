package com.hbs.lta.gateway;

import com.hbs.lta.model.LTABusStopResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LTAGatewayTest {

    private RestTemplate mockRestTemplate;
    private LTAGateway ltaGateway;

    @BeforeEach
    void setup() {
        mockRestTemplate = mock(RestTemplate.class);
        ltaGateway = new LTAGateway(mockRestTemplate);
        ReflectionTestUtils.setField(ltaGateway, "apiUrl", "https://mock.api.com/bus");
        ReflectionTestUtils.setField(ltaGateway, "apiKey", "mock-key");
    }

    @Test
    void shouldReturnLtaResponseWhenValidInputs() {
        // Given
        LTABusStopResponse mockResponse = new LTABusStopResponse();
        ResponseEntity<LTABusStopResponse> responseEntity = new ResponseEntity<>(mockResponse, HttpStatus.OK);

        // Match any URI string (since it's built dynamically)
        when(mockRestTemplate.exchange(
                any(URI.class),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(LTABusStopResponse.class))
        ).thenReturn(new ResponseEntity<>(new LTABusStopResponse(), HttpStatus.OK));

        // When
        LTABusStopResponse result = ltaGateway.getBusTimingsInBusStop(96129, "12");

        // Then
        assertNotNull(result);
        assertEquals(mockResponse, result);
    }
}
