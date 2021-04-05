package com.jn.xingdaba.resource.domain.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class DiscountBus {
    @Id
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

    private String createBy;

    @CreatedDate
    private LocalDateTime createTime;

    private String updateBy;

    @LastModifiedDate
    private LocalDateTime updateTime;
}
