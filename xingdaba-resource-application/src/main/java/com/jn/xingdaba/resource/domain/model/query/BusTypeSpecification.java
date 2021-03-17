package com.jn.xingdaba.resource.domain.model.query;

import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.domain.model.BusType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

@Slf4j
public class BusTypeSpecification {
    public static Specification<BusType> fromRequestData(BusTypeQueryRequestData requestData) {
        return (Specification<BusType>) (root, query, cb) -> {
            log.info("bus type query specification from request data: {}", requestData);
            Predicate finalConditions = cb.conjunction();
            if (requestData == null) {
                return finalConditions;
            }
            Path<String> busTypeName = root.get("busTypeName");
            Path<String> brand = root.get("brand");
            Path<String> isDelete = root.get("isDelete");

            if (StringUtils.hasText(requestData.getBusTypeName())) {
                finalConditions = cb.and(finalConditions, cb.like(busTypeName, "%" + requestData.getBusTypeName() + "%"));
            }

            if (StringUtils.hasText(requestData.getBrand())) {
                finalConditions = cb.and(finalConditions, cb.like(brand, "%" + requestData.getBrand() + "%"));
            }

            if (StringUtils.hasText(requestData.getIsDelete())) {
                finalConditions = cb.and(finalConditions, cb.equal(isDelete, requestData.getIsDelete()));
            }

            query.where(cb.and(finalConditions));
            return query.orderBy(cb.asc(root.get("seatNum"))).getRestriction();
        };
    }
}
