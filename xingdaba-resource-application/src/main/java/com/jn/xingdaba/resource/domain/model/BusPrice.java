package com.jn.xingdaba.resource.domain.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class BusPrice {

    @Id
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

    @CreatedDate
    private String createBy;

    private LocalDateTime createTime;

    @LastModifiedDate
    private String updateBy;

    private LocalDateTime updateTime;
}
