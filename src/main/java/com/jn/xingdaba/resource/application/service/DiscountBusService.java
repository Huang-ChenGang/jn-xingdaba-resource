package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.application.dto.DiscountBusDto;
import org.springframework.data.domain.Page;

public interface DiscountBusService {
    Page<DiscountBusDto> findAll(DiscountBusRequestData requestData);
}
