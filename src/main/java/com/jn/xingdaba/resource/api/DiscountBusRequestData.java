package com.jn.xingdaba.resource.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public final class DiscountBusRequestData {
    @PositiveOrZero
    private Integer pageNo;

    @Positive
    private Integer pageSize;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateBegin;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateEnd;

    @JsonFormat(timezone = "GMT+8",pattern = "HH:mm")
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime timeBegin;

    @JsonFormat(timezone = "GMT+8",pattern = "HH:mm")
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime timeEnd;

    private String busTypeName;

    private String busNumber;

    private String driverName;

    private String driverPhone;

    private String parkAddr;

    private String motorcade;

    private String shelfState;

    private String isDelete;
}
