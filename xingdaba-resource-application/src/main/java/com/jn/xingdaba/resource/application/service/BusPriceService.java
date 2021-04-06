package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.BusPriceRequestData;
import com.jn.xingdaba.resource.application.dto.BusPriceDto;
import org.springframework.data.domain.Page;

public interface BusPriceService {
    BusPriceDto findByBusTypeId(String busTypeId);

    Page<BusPriceDto> findAll(BusPriceRequestData requestData);
}
