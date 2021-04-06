package com.jn.xingdaba.resource.application.controller;

import com.jn.core.api.JnPageResponse;
import com.jn.core.api.ServerResponse;
import com.jn.xingdaba.resource.api.BusPriceRequestData;
import com.jn.xingdaba.resource.api.BusPriceResponseData;
import com.jn.xingdaba.resource.api.BusPriceSaveRequestData;
import com.jn.xingdaba.resource.application.dto.BusPriceDto;
import com.jn.xingdaba.resource.application.service.BusPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pageable")
    public ServerResponse<JnPageResponse<BusPriceResponseData>> findAll(BusPriceRequestData requestData) {
        Page<BusPriceResponseData> pageResult = service.findAll(requestData).map(BusPriceDto::toResponseData);
        log.info("find all bus price page result: {}", pageResult);
        return ServerResponse.success(JnPageResponse.of(pageResult));
    }

    @PostMapping
    public ServerResponse<String> save(@RequestBody @Validated BusPriceSaveRequestData requestData) {
        log.info("save bus price request data: {}", requestData);
        return ServerResponse.success(service.save(BusPriceSaveRequestData.toDto(requestData)));
    }

    @PostMapping("/{ids}")
    public ServerResponse<Void> deleteOrRestore(@PathVariable @NotBlank String ids) {
        service.deleteOrRestore(ids);
        return ServerResponse.success();
    }
}
