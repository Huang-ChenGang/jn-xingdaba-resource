package com.jn.xingdaba.resource.domain.model.query;

import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.domain.model.DiscountBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

@Slf4j
public class DiscountBusSpecification {
    public static Specification<DiscountBus> fromRequestData(DiscountBusRequestData requestData) {
        return (Specification<DiscountBus>) (root, query, cb) -> {
            log.info("discount bus query specification from request data: {}", requestData);
            Predicate finalConditions = cb.conjunction();
            if (requestData == null) {
                return finalConditions;
            }
            Path<String> shelfState = root.get("shelfState");
            Path<String> isDelete = root.get("isDelete");

            if (StringUtils.hasText(requestData.getShelfState())) {
                finalConditions = cb.and(finalConditions, cb.equal(shelfState, requestData.getShelfState()));
            }

            if (StringUtils.hasText(requestData.getIsDelete())) {
                finalConditions = cb.and(finalConditions, cb.equal(isDelete, requestData.getIsDelete()));
            }

            query.where(cb.and(finalConditions));
            return query.getRestriction();
        };
    }
}
