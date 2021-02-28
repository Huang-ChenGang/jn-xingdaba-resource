package com.jn.xingdaba.resource.application.controller;

import com.jn.core.api.JnPageResponse;
import com.jn.core.api.ServerResponse;
import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.api.BusTypeResponseData;
import com.jn.xingdaba.resource.api.BusTypeSaveRequestData;
import com.jn.xingdaba.resource.application.service.BusTypeApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Validated
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

    @GetMapping
    public ServerResponse<List<BusTypeResponseData>> findAll() {
        return ServerResponse.success(service.findAll().stream()
                .map(BusTypeResponseData::fromDto)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ServerResponse<String> save(@RequestBody @Validated BusTypeSaveRequestData requestData) {
        log.info("save bus type request data: {}", requestData);
        return ServerResponse.success(service.save(BusTypeSaveRequestData.toDto(requestData)));
    }

    @PostMapping("/{ids}")
    public ServerResponse<Void> deleteOrRestore(@PathVariable @NotBlank String ids) {
        service.deleteOrRestore(ids);
        return ServerResponse.success();
    }
}
