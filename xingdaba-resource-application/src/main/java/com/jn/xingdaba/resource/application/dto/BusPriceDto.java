package com.jn.xingdaba.resource.application.dto;

import com.jn.xingdaba.resource.api.BusPriceResponseData;
import com.jn.xingdaba.resource.domain.model.BusPrice;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
public final class BusPriceDto {
    private String id;

    private String busTypeId;

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

    public static BusPriceDto fromModel(BusPrice model) {
        BusPriceDto dto = new BusPriceDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public static BusPriceResponseData toResponseData(BusPriceDto dto) {
        BusPriceResponseData responseData = new BusPriceResponseData();
        BeanUtils.copyProperties(dto, responseData);
        return responseData;
    }
}
