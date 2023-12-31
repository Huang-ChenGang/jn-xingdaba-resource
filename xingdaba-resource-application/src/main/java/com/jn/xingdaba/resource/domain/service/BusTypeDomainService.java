package com.jn.xingdaba.resource.domain.service;

import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.domain.model.BusType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusTypeDomainService {
    Page<BusType> findAll(BusTypeQueryRequestData requestData, Pageable pageable);

    String save(BusType model);

    void deleteOrRestore(List<String> ids);

    List<BusType> findAll();

    List<BusType> findAllByIdIn(List<String> ids);

    BusType findById(String id);
}
