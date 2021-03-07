package com.jn.xingdaba.resource.application.controller;

import com.jn.core.api.JnPageResponse;
import com.jn.core.api.ServerResponse;
import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.api.DiscountBusResponseData;
import com.jn.xingdaba.resource.application.service.DiscountBusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/discount-buses")
public class DiscountBusController {
    private final DiscountBusService service;

    public DiscountBusController(DiscountBusService service) {
        this.service = service;
    }

    @GetMapping("/pageable")
    public ServerResponse<JnPageResponse<DiscountBusResponseData>> findAll(DiscountBusRequestData requestData) {
        return ServerResponse.success(JnPageResponse.of(
                service.findAll(requestData).map(DiscountBusResponseData::fromDto)));
    }
}
