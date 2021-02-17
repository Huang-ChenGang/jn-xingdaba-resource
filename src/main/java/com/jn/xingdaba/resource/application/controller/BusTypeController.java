package com.jn.xingdaba.resource.application.controller;

import com.jn.core.api.JnPageResponse;
import com.jn.core.api.ServerResponse;
import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.api.BusTypeResponseData;
import com.jn.xingdaba.resource.api.BusTypeSaveRequestData;
import com.jn.xingdaba.resource.application.service.BusTypeApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ServerResponse<JnPageResponse<BusTypeResponseData>> findAll(BusTypeQueryRequestData requestData) {
        Page<BusTypeResponseData> pageResult = service.findAll(requestData).map(BusTypeResponseData::fromDto);
        log.info("find all bus type page result: {}", pageResult);
        return ServerResponse.success(JnPageResponse.of(pageResult.getContent(), pageResult.getTotalElements()));
    }

    @PostMapping
    public ServerResponse<String> save(BusTypeSaveRequestData requestData) {
        log.info("save bus type request data: {}", requestData);
        return ServerResponse.success(service.save(BusTypeSaveRequestData.toDto(requestData)));
    }
}
