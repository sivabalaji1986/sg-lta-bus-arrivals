package com.hbs.lta.gateway;

import com.hbs.lta.model.LTABusStopResponse;
import com.hbs.lta.util.LTAConstants;
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

    public LTABusStopResponse getBusTimingsInBusStop(int busStopCode, String serviceNo) {
        try {
            logger.info("Calling LTA API for BusStopCode: {} & serviceNo: {}", busStopCode, serviceNo);

            URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .queryParam(LTAConstants.LTA_BUS_STOP_CODE, busStopCode)
                    .queryParam(LTAConstants.LTA_SERVICE_NO, serviceNo)
                    .build()
                    .toUri();

            HttpHeaders headers = new HttpHeaders();
            headers.set(LTAConstants.LTA_ACCOUNT_KEY, apiKey);
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));

            HttpEntity<Void> entity = new HttpEntity<>(headers);
            ResponseEntity<LTABusStopResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    LTABusStopResponse.class
            );

            logger.info("LTA Response: {}", response.getBody());
            return response.getBody();
        } catch (Exception exception) {
            logger.error("Error while calling LTA Bus Arrival API - {}", exception.getMessage());
            return null;
        }
    }

}
