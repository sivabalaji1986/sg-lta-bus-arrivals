package com.hbs.lta.service;

import com.hbs.lta.gateway.LTAGateway;
import com.hbs.lta.model.LTABusStopResponse;
import com.hbs.lta.model.LTAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LTABusTimingService {

    private static final Logger logger = LoggerFactory.getLogger(LTABusTimingService.class);

    private final LTAGateway ltaGateway;

    public LTABusTimingService(LTAGateway ltaGateway) {
        this.ltaGateway = ltaGateway;
    }

    public LTABusStopResponse getBusStopTimings(int busStopCode, int serviceNo){
        logger.info("getBusStopTimings BusStopCode: {} & serviceNo: {}", busStopCode, serviceNo);

        LTABusStopResponse ltaBusStopResponse = ltaGateway.getBusTimingsInBusStop(busStopCode, serviceNo);
        logger.info("getBusStopTimings ltaBusStopResponse: {}", ltaBusStopResponse);

        if(ltaBusStopResponse!=null){
            if(ltaBusStopResponse.getServices()!=null){
                for(LTAService ltaService : ltaBusStopResponse.getServices()){
                    if(ltaService.getNextBus()!=null){
                        if(ltaService.getNextBus().getVisitNumber().isBlank()){
                            ltaService.setNextBus(null);
                        }
                    }

                    if(ltaService.getNextBus2()!=null){
                        if(ltaService.getNextBus2().getVisitNumber().isBlank()){
                            ltaService.setNextBus2(null);
                        }
                    }

                    if(ltaService.getNextBus3()!=null){
                        if(ltaService.getNextBus3().getVisitNumber().isBlank()){
                            ltaService.setNextBus3(null);
                        }
                    }
                }
            }
        }

        logger.info("LtaBusStopResponse For BusStop# {} & serviceNo {} is - {}", busStopCode, serviceNo, ltaBusStopResponse);
        return ltaBusStopResponse;
    }

}
