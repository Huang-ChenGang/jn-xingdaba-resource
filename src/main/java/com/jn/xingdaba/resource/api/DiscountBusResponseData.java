package com.jn.xingdaba.resource.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.xingdaba.resource.application.dto.DiscountBusDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public final class DiscountBusResponseData {
    private String id;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateBegin;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateEnd;

    @JsonFormat(timezone = "GMT+8",pattern = "HH:mm:ss")
    @DateTimeFormat(pattern="HH:mm:ss")
    private LocalTime timeBegin;

    @JsonFormat(timezone = "GMT+8",pattern = "HH:mm:ss")
    @DateTimeFormat(pattern="HH:mm:ss")
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

    public static DiscountBusResponseData fromDto(DiscountBusDto dto) {
        DiscountBusResponseData responseData = new DiscountBusResponseData();
        BeanUtils.copyProperties(dto, responseData);
        return responseData;
    }
}
