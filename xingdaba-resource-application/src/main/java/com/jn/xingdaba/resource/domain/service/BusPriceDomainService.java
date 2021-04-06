package com.jn.xingdaba.resource.domain.service;

import com.jn.xingdaba.resource.api.BusPriceRequestData;
import com.jn.xingdaba.resource.domain.model.BusPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusPriceDomainService {
    BusPrice findByBusTypeId(String busTypeId);

    Page<BusPrice> findAll(BusPriceRequestData requestData, Pageable pageable);

    String save(BusPrice model);

    void deleteOrRestore(List<String> ids);
}
