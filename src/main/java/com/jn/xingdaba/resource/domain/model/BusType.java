package com.jn.xingdaba.resource.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
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

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;
}
