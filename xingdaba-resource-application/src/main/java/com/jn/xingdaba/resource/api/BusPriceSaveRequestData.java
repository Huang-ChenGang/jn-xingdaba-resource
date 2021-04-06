package com.jn.xingdaba.resource.api;

import com.jn.xingdaba.resource.application.dto.BusPriceDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public final class BusPriceSaveRequestData {

    private String id;

    @NotBlank(message = "车型ID不能为空")
    private String busTypeId;

    @NotBlank(message = "车型名称不能为空")
    private String busTypeName;

    private BigDecimal cost;

    private BigDecimal kmUnitPrice;

    private BigDecimal tax;

    private BigDecimal couponRatio;

    private BigDecimal dayMarkupRatio;

    private BigDecimal hrUnitPrice;

    private BigDecimal overTimeCost;

    private BigDecimal overKmCost;

    private BigDecimal giveHourRatio;

    private BigDecimal giveKmRatio;

    private BigDecimal emptyKmUnitPrice;

    private BigDecimal transferRates;

    private BigDecimal discountRates;

    private BigDecimal daysRatio;

    private String isDelete;

    public static BusPriceDto toDto(BusPriceSaveRequestData requestData) {
        BusPriceDto dto = new BusPriceDto();
        BeanUtils.copyProperties(requestData, dto);
        return dto;
    }
}
