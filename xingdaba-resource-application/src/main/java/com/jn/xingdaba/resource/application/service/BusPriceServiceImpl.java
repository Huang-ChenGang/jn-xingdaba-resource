package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.application.dto.BusPriceDto;
import com.jn.xingdaba.resource.domain.service.BusPriceDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusPriceServiceImpl implements BusPriceService {
    private final BusPriceDomainService domainService;

    public BusPriceServiceImpl(BusPriceDomainService domainService) {
        this.domainService = domainService;
    }

    @Override
    public BusPriceDto findByBusTypeId(String busTypeId) {
        log.info("find bus price by busTypeId: {}", busTypeId);
        return BusPriceDto.fromModel(domainService.findByBusTypeId(busTypeId));
    }
}
