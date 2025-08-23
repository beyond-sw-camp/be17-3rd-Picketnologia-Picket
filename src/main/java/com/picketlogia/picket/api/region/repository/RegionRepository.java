package com.picketlogia.picket.api.region.repository;

import com.picketlogia.picket.api.region.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Optional<Region> findByCode(String code);
}
