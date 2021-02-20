package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.application.dto.BusTypeResponseDto;
import com.jn.xingdaba.resource.application.dto.BusTypeSaveRequestDto;
import com.jn.xingdaba.resource.domain.service.BusTypeDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    @Override
    public String save(BusTypeSaveRequestDto requestDto) {
        log.info("save bus type request dto: {}", requestDto);
        return domainService.save(BusTypeSaveRequestDto.toModel(requestDto));
    }

    @Override
    public void deleteOrRestore(String ids) {
        log.info("delete or restore bus type for: {}", ids);
        domainService.deleteOrRestore(Arrays.asList(ids.split(",")));
    }
}
