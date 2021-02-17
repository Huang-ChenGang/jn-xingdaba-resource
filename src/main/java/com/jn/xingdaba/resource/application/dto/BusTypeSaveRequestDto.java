package com.jn.xingdaba.resource.application.dto;

import com.jn.xingdaba.resource.domain.model.BusType;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public final class BusTypeSaveRequestDto {

    private String id;

    private String busTypeName;

    private Integer seatNum;

    private String brand;

    private String description;

    private String headImg;

    private String sidewaysImg;

    private String interiorImg;

    private String isDelete;

    public static BusType toModel(BusTypeSaveRequestDto dto) {
        BusType model = new BusType();
        BeanUtils.copyProperties(dto, model);
        return model;
    }
}
