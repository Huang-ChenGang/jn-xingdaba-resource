package com.jn.xingdaba.resource.application.dto;

import com.jn.xingdaba.resource.domain.model.DiscountBus;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public final class DiscountBusDto {
    private String id;

    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private LocalTime timeBegin;
    private LocalTime timeEnd;

    private String busTypeId;
    private String busTypeName;

    private String busNumber;
    private String driverName;
    private String driverPhone;

    private String parkAddr;

    private String motorcade;

    private String district;

    private String shelfState;

    private String homeImg;

    private String listImg;

    private String isDelete;

    public static DiscountBusDto fromModel(DiscountBus model) {
        DiscountBusDto dto = new DiscountBusDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }
}
