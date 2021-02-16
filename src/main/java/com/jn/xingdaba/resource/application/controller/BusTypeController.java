package com.jn.xingdaba.resource.application.controller;

import com.jn.core.api.ServerResponse;
import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.api.BusTypeResponseData;
import com.jn.xingdaba.resource.application.service.BusTypeApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/bus-types")
public class BusTypeController {
    private final BusTypeApplicationService service;

    public BusTypeController(BusTypeApplicationService service) {
        this.service = service;
    }

    @GetMapping("/pageable")
    public ServerResponse<Page<BusTypeResponseData>> findAll(BusTypeQueryRequestData requestData) {
        return ServerResponse.success(service.findAll(requestData).map(BusTypeResponseData::fromDto));
    }
}
