package com.jn.xingdaba.resource.api;

import com.jn.core.api.SaveReq;
import com.jn.xingdaba.resource.application.dto.BusTypeSaveRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

@EqualsAndHashCode(callSuper = true)
@Data
public final class BusTypeSaveRequestData extends SaveReq {

    private String busTypeName;

    private Integer seatNum;

    private String brand;

    private String description;

    private String headImg;

    private String sidewaysImg;

    private String interiorImg;

    private String isDelete;

    public static BusTypeSaveRequestDto toDto(BusTypeSaveRequestData requestData) {
        BusTypeSaveRequestDto dto = new BusTypeSaveRequestDto();
        BeanUtils.copyProperties(requestData, dto);
        return dto;
    }
}
