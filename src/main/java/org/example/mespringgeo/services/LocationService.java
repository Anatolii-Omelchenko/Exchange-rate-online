package org.example.mespringgeo.services;

import org.example.mespringgeo.dto.LocationDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocationService {
    void save(LocationDTO dto);
    long count();
    List<LocationDTO> getLocations(Pageable pageable);
}
