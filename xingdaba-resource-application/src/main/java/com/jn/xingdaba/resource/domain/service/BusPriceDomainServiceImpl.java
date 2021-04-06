package com.jn.xingdaba.resource.domain.service;

import com.jn.core.builder.KeyBuilder;
import com.jn.xingdaba.resource.api.BusPriceRequestData;
import com.jn.xingdaba.resource.domain.model.BusPrice;
import com.jn.xingdaba.resource.domain.model.query.BusPriceSpecification;
import com.jn.xingdaba.resource.domain.repository.BusPriceRepository;
import com.jn.xingdaba.resource.infrastructure.exception.BusPriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Slf4j
@Service
public class BusPriceDomainServiceImpl implements BusPriceDomainService {
    private final BusPriceRepository repository;
    private final KeyBuilder keyBuilder;

    public BusPriceDomainServiceImpl(BusPriceRepository repository,
                                     KeyBuilder keyBuilder) {
        this.repository = repository;
        this.keyBuilder = keyBuilder;
    }

    @Override
    public BusPrice findByBusTypeId(String busTypeId) {
        return repository.findByBusTypeId(busTypeId).orElseThrow(BusPriceNotFoundException::new);
    }

    @Override
    public Page<BusPrice> findAll(BusPriceRequestData requestData, Pageable pageable) {
        Specification<BusPrice> specification = BusPriceSpecification.fromRequestData(requestData);
        return repository.findAll(specification, pageable);
    }

    @Override
    public String save(BusPrice model) {
        if (StringUtils.isEmpty(model.getId())) {
            model.setId(keyBuilder.getUniqueKey());
        }
        if (StringUtils.isEmpty(model.getIsDelete())) {
            model.setIsDelete("0");
        }

        Optional<BusPrice> oldValue = repository.findById(model.getId());
        if (oldValue.isPresent()) {
            model.setCreateTime(oldValue.get().getCreateTime());
            model.setCreateBy(oldValue.get().getCreateBy());
        }

        return repository.save(model).getId();
    }
}
