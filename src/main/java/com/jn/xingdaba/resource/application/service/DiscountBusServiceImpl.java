package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.application.dto.DiscountBusDto;
import com.jn.xingdaba.resource.domain.service.DiscountBusDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DiscountBusServiceImpl implements DiscountBusService {
    private final DiscountBusDomainService domainService;

    public DiscountBusServiceImpl(DiscountBusDomainService domainService) {
        this.domainService = domainService;
    }

    @Override
    public Page<DiscountBusDto> findAll(DiscountBusRequestData requestData) {
        log.info("find pageable discount bus for: {}", requestData);
        Pageable pageable = PageRequest.of(requestData.getPageNo(), requestData.getPageSize());
        return domainService.findAll(requestData, pageable)
                .map(DiscountBusDto::fromModel);
    }
}
