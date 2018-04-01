package demo.service.impl;

import demo.model.CurrentPosition;
import demo.model.SupplyLocation;
import demo.service.SupplyLocationService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DefaultSupplyLocationService implements SupplyLocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSupplyLocationService.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void updateSupplyLocations(CurrentPosition currentPosition) {
        switch (currentPosition.getRunnerStatus()) {
            case SERVICE_NOW:
            case SERVICE_SOON:
            case STOP_NOW:
                ResponseEntity<Resource<SupplyLocation>> result = this.restTemplate.exchange(
                        "http://supply-location-service/supplyLocations/search/findFirstByLocationNear?location={lat},{long}",
                        HttpMethod.GET, new HttpEntity<Void>((Void) null),
                        new ParameterizedTypeReference<Resource<SupplyLocation>>() {
                        }, currentPosition.getLocation().getLatitude(),
                        currentPosition.getLocation().getLongitude());
                if (result.getStatusCode() == HttpStatus.OK
                        && result.getBody().getContent() != null) {
                    currentPosition.setSupplyLocation(result.getBody().getContent());
                }
                break;
            default:
        }
    }

    public void handleSupplyLocationServiceFailure(CurrentPosition currentPosition) {
        LOGGER.error("Hystrix Fallback Method. Unable to retrieve service station info.");
    }
}
