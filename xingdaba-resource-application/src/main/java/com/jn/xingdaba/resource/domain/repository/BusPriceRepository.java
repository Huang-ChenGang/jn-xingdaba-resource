package com.jn.xingdaba.resource.domain.repository;

import com.jn.xingdaba.resource.domain.model.BusPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BusPriceRepository extends JpaRepository<BusPrice, String>, JpaSpecificationExecutor<BusPrice> {

    Optional<BusPrice> findByBusTypeId(String busTypeId);
}
