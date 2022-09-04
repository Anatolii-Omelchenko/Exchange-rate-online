package org.example.mespringgeo.controllers;

import org.example.mespringgeo.dto.LocationDTO;
import org.example.mespringgeo.dto.PageCountDTO;
import org.example.mespringgeo.services.LocationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final int PAGE_SIZE = 5;

    private final LocationService locationService;

    public AdminController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("count")
    public PageCountDTO count() {
        return PageCountDTO.of(locationService.count(), PAGE_SIZE);
    }

    @GetMapping("geo")
    public List<LocationDTO> locations(
            @RequestParam(required = false, defaultValue = "0") int page) {
        return locationService.getLocations(
                PageRequest.of(page, PAGE_SIZE, Sort.Direction.DESC, "id"));
    }
}
