package com.jn.xingdaba.resource.api;

import lombok.Data;

@Data
public final class BusTypeRecommendResponseData {

    private String id;

    private Integer busCount;

    private String busTypeName;

    private String headImg;

    private String sidewaysImg;

    private String interiorImg;
}
