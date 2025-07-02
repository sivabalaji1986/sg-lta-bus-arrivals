package com.hbs.lta.gateway;

import com.hbs.lta.model.LTABusStopResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
public class LTAGateway {

    private static final Logger logger = LoggerFactory.getLogger(LTAGateway.class);

    private final RestTemplate restTemplate;

    @Value("${sg-lta.api.key}")
    private String apiKey;

    @Value("${sg-lta.api.url}")
    private String apiUrl;

    public LTAGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LTABusStopResponse getBusTimingsInBusStop(int busStopCode, int serviceNo) {
        try {
            logger.info("Calling LTA API for BusStopCode: {} & serviceNo: {}", busStopCode, serviceNo);

            HttpHeaders headers = new HttpHeaders();
            headers.set("AccountKey", apiKey);
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .queryParam("BusStopCode", busStopCode)
                    .queryParam("ServiceNo", serviceNo)
                    .build()
                    .toUri();

            ResponseEntity<LTABusStopResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    LTABusStopResponse.class
            );

            return response.getBody();
        } catch (Exception exception) {
            logger.error("Error while calling LTA Bus Arrival API - {}", exception.getMessage());
            return null;
        }
    }

}
