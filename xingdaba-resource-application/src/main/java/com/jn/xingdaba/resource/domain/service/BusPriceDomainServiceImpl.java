package com.jn.xingdaba.resource.domain.service;

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

@Slf4j
@Service
public class BusPriceDomainServiceImpl implements BusPriceDomainService {
    private final BusPriceRepository repository;

    public BusPriceDomainServiceImpl(BusPriceRepository repository) {
        this.repository = repository;
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
}
