package com.jn.xingdaba.resource.domain.service;

import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.domain.model.DiscountBus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiscountBusDomainService {
    Page<DiscountBus> findAll(DiscountBusRequestData requestData, Pageable pageable);
}
