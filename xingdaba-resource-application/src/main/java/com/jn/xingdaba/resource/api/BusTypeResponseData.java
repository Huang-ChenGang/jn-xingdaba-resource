package com.jn.xingdaba.resource.api;

import com.jn.xingdaba.resource.application.dto.BusTypeResponseDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public final class BusTypeResponseData {
    private String id;

    private String busTypeName;

    private Integer seatNum;

    private String brand;

    private String description;

    private String headImg;

    private String sidewaysImg;

    private String interiorImg;

    private String isDelete;

    public static BusTypeResponseData fromDto(BusTypeResponseDto dto) {
        BusTypeResponseData responseData = new BusTypeResponseData();
        BeanUtils.copyProperties(dto, responseData);
        return responseData;
    }
}
