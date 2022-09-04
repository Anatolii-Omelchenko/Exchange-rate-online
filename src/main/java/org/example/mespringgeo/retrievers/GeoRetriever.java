package org.example.mespringgeo.retrievers;

import org.example.mespringgeo.dto.LocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeoRetriever {
    private static final String URL = "http://ipinfo.io/";

    public LocationDTO getLocation(String ip) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LocationDTO> response = restTemplate.getForEntity(URL + ip,
                LocationDTO.class);
        return response.getBody();
    }
}
