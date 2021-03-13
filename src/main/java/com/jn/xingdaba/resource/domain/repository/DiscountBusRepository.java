package com.jn.xingdaba.resource.domain.repository;

import com.jn.xingdaba.resource.domain.model.DiscountBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountBusRepository extends JpaRepository<DiscountBus, String>, JpaSpecificationExecutor<DiscountBus> {
    List<DiscountBus> findAllByIdIn(List<String> ids);
}
