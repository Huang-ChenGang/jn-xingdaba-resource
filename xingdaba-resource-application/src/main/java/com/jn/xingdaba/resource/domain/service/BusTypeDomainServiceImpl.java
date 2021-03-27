package com.jn.xingdaba.resource.domain.service;

import com.jn.core.builder.KeyBuilder;
import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.domain.model.BusType;
import com.jn.xingdaba.resource.domain.model.query.BusTypeSpecification;
import com.jn.xingdaba.resource.domain.repository.BusTypeRepository;
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
public class BusTypeDomainServiceImpl implements BusTypeDomainService {
    private final BusTypeRepository repository;
    private final KeyBuilder keyBuilder;

    public BusTypeDomainServiceImpl(BusTypeRepository repository, KeyBuilder keyBuilder) {
        this.repository = repository;
        this.keyBuilder = keyBuilder;
    }

    @Override
    public Page<BusType> findAll(BusTypeQueryRequestData requestData, Pageable pageable) {
        Specification<BusType> specification = BusTypeSpecification.fromRequestData(requestData);
        return repository.findAll(specification, pageable);
    }

    @Override
    public String save(BusType model) {
        if (StringUtils.isEmpty(model.getId())) {
            model.setId(keyBuilder.getUniqueKey());
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
    public List<BusType> findAll() {
        return repository.findAllByIsDeleteOrderBySeatNumAsc("0");
    }

    @Override
    public List<BusType> findAllByIdIn(List<String> ids) {
        return repository.findAllByIdIn(ids);
    }
}
