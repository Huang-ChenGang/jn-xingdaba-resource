package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.BusPriceRequestData;
import com.jn.xingdaba.resource.application.dto.BusPriceDto;
import com.jn.xingdaba.resource.domain.service.BusPriceDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    @Override
    public Page<BusPriceDto> findAll(BusPriceRequestData requestData) {
        log.info("find pageable bus price request data: {}", requestData);
        Pageable pageable = PageRequest.of(requestData.getPageNo(), requestData.getPageSize());
        return domainService.findAll(requestData, pageable)
                .map(BusPriceDto::fromModel);
    }

    @Override
    public String save(BusPriceDto requestDto) {
        log.info("save bus price request dto: {}", requestDto);
        return domainService.save(BusPriceDto.toModel(requestDto));
    }

    @Override
    public void deleteOrRestore(String ids) {
        log.info("delete or restore bus price for: {}", ids);
        domainService.deleteOrRestore(Arrays.asList(ids.split(",")));
    }
}
