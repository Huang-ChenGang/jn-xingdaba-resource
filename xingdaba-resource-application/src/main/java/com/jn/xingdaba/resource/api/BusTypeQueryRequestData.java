package com.jn.xingdaba.resource.api;

import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public final class BusTypeQueryRequestData {

    @PositiveOrZero
    private Integer pageNo;

    @Positive
    private Integer pageSize;

    private String isDelete;

    private String busTypeName;

    private String brand;
}
