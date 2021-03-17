package com.jn.xingdaba.resource.application.controller;

import com.jn.core.api.ServerResponse;
import com.jn.xingdaba.resource.api.BusPriceResponseData;
import com.jn.xingdaba.resource.application.dto.BusPriceDto;
import com.jn.xingdaba.resource.application.service.BusPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Slf4j
@Validated
@RestController
@RequestMapping("/bus-prices")
public class BusPriceController {
    private final BusPriceService service;

    public BusPriceController(BusPriceService service) {
        this.service = service;
    }

    @GetMapping("/bus-type/{busTypeId}")
    public ServerResponse<BusPriceResponseData> findByBusTypeId(@PathVariable @NotBlank String busTypeId) {
        return ServerResponse.success(BusPriceDto.toResponseData(service.findByBusTypeId(busTypeId)));
    }
}
