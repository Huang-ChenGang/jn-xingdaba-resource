package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.application.dto.BusPriceDto;

public interface BusPriceService {
    BusPriceDto findByBusTypeId(String busTypeId);
}
