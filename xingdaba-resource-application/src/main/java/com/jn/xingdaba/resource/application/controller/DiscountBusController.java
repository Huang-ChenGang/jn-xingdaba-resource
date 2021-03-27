package com.jn.xingdaba.resource.application.controller;

import com.jn.core.api.JnPageResponse;
import com.jn.core.api.ServerResponse;
import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.api.DiscountBusResponseData;
import com.jn.xingdaba.resource.api.DiscountBusSaveRequestData;
import com.jn.xingdaba.resource.application.service.DiscountBusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @PostMapping
    public ServerResponse<String> save(@RequestBody @Validated @NotNull DiscountBusSaveRequestData requestData) {
        return ServerResponse.success(service.save(DiscountBusSaveRequestData.toDto(requestData)));
    }

    @PostMapping("/{ids}")
    public ServerResponse<Void> deleteOrRestore(@PathVariable @NotBlank String ids) {
        service.deleteOrRestore(ids);
        return ServerResponse.success();
    }

    @PostMapping("/shelf/{ids}")
    public ServerResponse<Void> shelfOnOrOff(@PathVariable @NotBlank String ids) {
        service.shelfOnOrOff(ids);
        return ServerResponse.success();
    }

    @GetMapping("/{id}")
    public ServerResponse<DiscountBusResponseData> findById(@PathVariable @NotBlank String id) {
        return ServerResponse.success(DiscountBusResponseData.fromDto(service.findById(id)));
    }
}
