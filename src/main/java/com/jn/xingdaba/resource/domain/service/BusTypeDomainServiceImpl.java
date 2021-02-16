package com.jn.xingdaba.resource.domain.service;

import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.domain.model.BusType;
import com.jn.xingdaba.resource.domain.model.query.BusTypeSpecification;
import com.jn.xingdaba.resource.domain.repository.BusTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusTypeDomainServiceImpl implements BusTypeDomainService {
    private final BusTypeRepository repository;

    public BusTypeDomainServiceImpl(BusTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<BusType> findAll(BusTypeQueryRequestData requestData, Pageable pageable) {
        Specification<BusType> specification = BusTypeSpecification.fromRequestData(requestData);
        return repository.findAll(specification, pageable);
    }
}
