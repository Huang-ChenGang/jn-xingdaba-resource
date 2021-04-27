package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.application.dto.DiscountBusDto;
import com.jn.xingdaba.resource.domain.service.BusTypeDomainService;
import com.jn.xingdaba.resource.domain.service.DiscountBusDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class DiscountBusServiceImpl implements DiscountBusService {
    private final DiscountBusDomainService domainService;
    private final BusTypeDomainService busTypeDomainService;

    public DiscountBusServiceImpl(DiscountBusDomainService domainService,
                                  BusTypeDomainService busTypeDomainService) {
        this.domainService = domainService;
        this.busTypeDomainService = busTypeDomainService;
    }

    @Override
    public Page<DiscountBusDto> findAll(DiscountBusRequestData requestData) {
        log.info("find pageable discount bus for: {}", requestData);
        Pageable pageable = PageRequest.of(requestData.getPageNo(), requestData.getPageSize());
        return domainService.findAll(requestData, pageable)
                .map(DiscountBusDto::fromModel);
    }

    @Override
    public String save(DiscountBusDto dto) {
        log.info("save discount bus for request dto: {}", dto);
        return domainService.save(DiscountBusDto.toModel(dto));
    }

    @Override
    public void deleteOrRestore(String ids) {
        log.info("delete or restore discount bus for: {}", ids);
        domainService.deleteOrRestore(Arrays.asList(ids.split(",")));
    }

    @Override
    public void shelfOnOrOff(String ids) {
        log.info("shelf on or off discount bus for: {}", ids);
        domainService.shelfOnOrOff(Arrays.asList(ids.split(",")));
    }

    @Override
    public DiscountBusDto findById(String id) {
        DiscountBusDto dto = DiscountBusDto.fromModel(domainService.findById(id));
        dto.setSeatNum(busTypeDomainService.findById(dto.getBusTypeId()).getSeatNum());
        return dto;
    }
}
