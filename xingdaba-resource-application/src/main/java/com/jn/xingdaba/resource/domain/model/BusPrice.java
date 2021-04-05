package com.jn.xingdaba.resource.domain.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
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

    private String createBy;

    @CreatedDate
    private LocalDateTime createTime;

    private String updateBy;

    @LastModifiedDate
    private LocalDateTime updateTime;
}
