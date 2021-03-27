package com.jn.xingdaba.resource.domain.service;

import com.jn.core.builder.KeyBuilder;
import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.domain.model.DiscountBus;
import com.jn.xingdaba.resource.domain.model.query.DiscountBusSpecification;
import com.jn.xingdaba.resource.domain.repository.DiscountBusRepository;
import com.jn.xingdaba.resource.infrastructure.exception.BusTypeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DiscountBusDomainServiceImpl implements DiscountBusDomainService {
    private final DiscountBusRepository repository;
    private final KeyBuilder keyBuilder;

    public DiscountBusDomainServiceImpl(DiscountBusRepository repository,
                                        KeyBuilder keyBuilder) {
        this.repository = repository;
        this.keyBuilder = keyBuilder;
    }

    @Override
    public Page<DiscountBus> findAll(DiscountBusRequestData requestData, Pageable pageable) {
        Specification<DiscountBus> specification = DiscountBusSpecification.fromRequestData(requestData);
        return repository.findAll(specification, pageable);
    }

    @Override
    public String save(DiscountBus model) {
        if (StringUtils.isEmpty(model.getId())) {
            model.setId(keyBuilder.getUniqueKey());
        }
        if (StringUtils.isEmpty(model.getShelfState())) {
            model.setShelfState("no");
        }
        if (StringUtils.isEmpty(model.getIsDelete())) {
            model.setIsDelete("0");
        }

        return repository.save(model).getId();
    }

    @Override
    public void deleteOrRestore(List<String> ids) {
        repository.saveAll(repository.findAllByIdIn(ids).stream()
                .peek(m -> m.setIsDelete("1".equals(m.getIsDelete()) ? "0" : "1"))
                .collect(Collectors.toList()));
    }

    @Override
    public void shelfOnOrOff(List<String> ids) {
        repository.saveAll(repository.findAllByIdIn(ids).stream()
                .peek(m -> m.setShelfState("on".equals(m.getShelfState()) ? "off" : "on"))
                .collect(Collectors.toList()));
    }

    @Override
    public DiscountBus findById(String id) {
        return repository.findById(id).orElseThrow(BusTypeNotFoundException::new);
    }
}
