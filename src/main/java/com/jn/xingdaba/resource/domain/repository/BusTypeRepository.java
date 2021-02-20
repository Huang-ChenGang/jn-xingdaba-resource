package com.jn.xingdaba.resource.domain.repository;

import com.jn.xingdaba.resource.domain.model.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusTypeRepository extends JpaRepository<BusType, String>, JpaSpecificationExecutor<BusType> {
    void deleteBusTypesByIdIn(List<String> ids);

    List<BusType> findAllByIdIn(List<String> ids);
}
