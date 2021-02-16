package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.application.dto.BusTypeResponseDto;
import org.springframework.data.domain.Page;

public interface BusTypeApplicationService {
    Page<BusTypeResponseDto> findAll(BusTypeQueryRequestData requestData);
}
