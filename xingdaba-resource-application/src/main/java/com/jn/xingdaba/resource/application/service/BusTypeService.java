package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.api.BusTypeRecommendResponseData;
import com.jn.xingdaba.resource.application.dto.BusTypeResponseDto;
import com.jn.xingdaba.resource.application.dto.BusTypeSaveRequestDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BusTypeService {
    Page<BusTypeResponseDto> findAll(BusTypeQueryRequestData requestData);

    String save(BusTypeSaveRequestDto requestDto);

    void deleteOrRestore(String ids);

    List<BusTypeResponseDto> findAll();

    List<BusTypeRecommendResponseData> recommendBusType(Integer passengerNumber);

    BusTypeResponseDto findById(String id);
}
