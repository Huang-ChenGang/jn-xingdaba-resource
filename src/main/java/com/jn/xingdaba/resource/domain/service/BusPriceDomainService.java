package com.jn.xingdaba.resource.domain.service;

import com.jn.xingdaba.resource.domain.model.BusPrice;

public interface BusPriceDomainService {
    BusPrice findByBusTypeId(String busTypeId);
}
