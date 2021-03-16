package com.jn.xingdaba.resource.domain.service;

import com.jn.xingdaba.resource.domain.model.BusPrice;
import com.jn.xingdaba.resource.domain.repository.BusPriceRepository;
import com.jn.xingdaba.resource.infrastructure.exception.BusPriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
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
}
