package com.jn.xingdaba.resource.domain.repository;

import com.jn.xingdaba.resource.domain.model.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusTypeRepository extends JpaRepository<BusType, String> {
}
