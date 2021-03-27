package com.jn.xingdaba.resource.application.dto;

import com.jn.xingdaba.resource.api.BusTypeResponseData;
import com.jn.xingdaba.resource.domain.model.BusType;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public final class BusTypeResponseDto {
    private String id;

    private String busTypeName;

    private Integer seatNum;

    private String brand;

    private String description;

    private String headImg;

    private String sidewaysImg;

    private String interiorImg;

    private String isDelete;

    public static BusTypeResponseDto fromModel(BusType model) {
        BusTypeResponseDto dto = new BusTypeResponseDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public static BusTypeResponseData toResponseData(BusTypeResponseDto dto) {
        BusTypeResponseData responseData = new BusTypeResponseData();
        BeanUtils.copyProperties(dto, responseData);
        return responseData;
    }
}
