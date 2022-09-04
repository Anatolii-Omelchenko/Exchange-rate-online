package org.example.mespringgeo.repo;

import org.example.mespringgeo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location, Long> {
}
