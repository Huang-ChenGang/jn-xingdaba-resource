package com.jn.xingdaba.resource.domain.service;

import com.jn.xingdaba.resource.domain.model.DiscountBus;
import com.jn.xingdaba.resource.domain.repository.DiscountBusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DiscountBusDomainServiceImpl implements DiscountBusDomainService {
    private final DiscountBusRepository repository;

    public DiscountBusDomainServiceImpl(DiscountBusRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<DiscountBus> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
