package com.jn.xingdaba.resource.domain.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class BusType {

    @Id
    private String id;

    private String busTypeName;

    private Integer seatNum;

    private String brand;

    private String description;

    private String headImg;

    private String sidewaysImg;

    private String interiorImg;

    private String isDelete;

    private String createBy;

    @CreatedDate
    private LocalDateTime createTime;

    private String updateBy;

    @LastModifiedDate
    private LocalDateTime updateTime;
}
