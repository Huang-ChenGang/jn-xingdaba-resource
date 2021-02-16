package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.application.dto.BusTypeResponseDto;
import com.jn.xingdaba.resource.domain.service.BusTypeDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusTypeApplicationServiceImpl implements BusTypeApplicationService {
    private final BusTypeDomainService domainService;

    public BusTypeApplicationServiceImpl(BusTypeDomainService domainService) {
        this.domainService = domainService;
    }

    @Override
    public Page<BusTypeResponseDto> findAll(BusTypeQueryRequestData requestData) {
        log.info("find pageable bus type request data: {}", requestData);
        Pageable pageable = PageRequest.of(requestData.getPageNo(), requestData.getPageSize());
        return domainService.findAll(requestData, pageable).map(BusTypeResponseDto::fromModel);
    }
}
