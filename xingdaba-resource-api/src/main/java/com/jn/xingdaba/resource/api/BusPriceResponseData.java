package com.jn.xingdaba.resource.api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public final class BusPriceResponseData {
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
}
