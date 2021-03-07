package com.jn.xingdaba.resource.api;

import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public final class DiscountBusRequestData {
    @PositiveOrZero
    private Integer pageNo;

    @Positive
    private Integer pageSize;
}
