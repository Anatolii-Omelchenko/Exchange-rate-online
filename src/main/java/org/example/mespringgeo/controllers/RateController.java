package org.example.mespringgeo.controllers;

import org.example.mespringgeo.dto.LocationDTO;
import org.example.mespringgeo.json.Rate;
import org.example.mespringgeo.retrievers.GeoRetriever;
import org.example.mespringgeo.retrievers.RateRetriever;
import org.example.mespringgeo.services.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;

@RestController
public class RateController {
    private final RateRetriever rateRetriever;
    private final GeoRetriever geoRetriever;
    private final LocationService locationService;

    public RateController(RateRetriever rateRetriever, GeoRetriever geoRetriever,
                          LocationService locationService) {
        this.rateRetriever = rateRetriever;
        this.geoRetriever = geoRetriever;
        this.locationService = locationService;
    }

    @GetMapping("/rate")
    public Rate rate(HttpServletRequest request) {
        String ip = request.getRemoteAddr();

        LocationDTO location = geoRetriever.getLocation(ip);
        locationService.save(location);

        return rateRetriever.getRate();
    }
}
