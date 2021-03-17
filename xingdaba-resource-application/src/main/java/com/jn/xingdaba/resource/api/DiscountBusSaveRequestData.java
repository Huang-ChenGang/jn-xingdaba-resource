package com.jn.xingdaba.resource.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.xingdaba.resource.application.dto.DiscountBusDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public final class DiscountBusSaveRequestData {
    private String id;

    @NotNull(message = "开始日期不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateBegin;

    @NotNull(message = "结束日期不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateEnd;

    @NotNull(message = "开始时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "HH:mm")
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime timeBegin;

    @NotNull(message = "结束时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "HH:mm")
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime timeEnd;

    @NotBlank(message = "车型不能为空")
    private String busTypeId;

    @NotBlank(message = "车型不能为空")
    private String busTypeName;

    @NotBlank(message = "车牌号不能为空")
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

    public static DiscountBusDto toDto(DiscountBusSaveRequestData requestData) {
        DiscountBusDto dto = new DiscountBusDto();
        BeanUtils.copyProperties(requestData, dto);
        return dto;
    }
}
