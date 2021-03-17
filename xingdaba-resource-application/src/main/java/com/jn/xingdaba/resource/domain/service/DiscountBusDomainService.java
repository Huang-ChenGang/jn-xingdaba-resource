package com.jn.xingdaba.resource.domain.service;

import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.domain.model.DiscountBus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DiscountBusDomainService {
    Page<DiscountBus> findAll(DiscountBusRequestData requestData, Pageable pageable);

    String save(DiscountBus model);

    void deleteOrRestore(List<String> ids);

    void shelfOnOrOff(List<String> ids);
}
