package com.jn.xingdaba.resource.api;

import lombok.Data;

@Data
public final class BusTypeResponseData {
    private String id;

    private String busTypeName;

    private Integer seatNum;

    private String brand;

    private String description;

    private String headImg;

    private String sidewaysImg;

    private String interiorImg;

    private String isDelete;

}
