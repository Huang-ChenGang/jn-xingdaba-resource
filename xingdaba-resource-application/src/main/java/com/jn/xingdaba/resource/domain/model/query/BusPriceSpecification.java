package com.jn.xingdaba.resource.domain.model.query;

import com.jn.xingdaba.resource.api.BusPriceRequestData;
import com.jn.xingdaba.resource.domain.model.BusPrice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

@Slf4j
public class BusPriceSpecification {
    public static Specification<BusPrice> fromRequestData(BusPriceRequestData requestData) {
        return (Specification<BusPrice>) (root, query, cb) -> {
            log.info("bus price query specification from request data: {}", requestData);
            Predicate finalConditions = cb.conjunction();
            if (requestData == null) {
                return finalConditions;
            }
            Path<String> isDelete = root.get("isDelete");

            if (StringUtils.hasText(requestData.getIsDelete())) {
                finalConditions = cb.and(finalConditions, cb.equal(isDelete, requestData.getIsDelete()));
            }

            query.where(cb.and(finalConditions));
            return query.getRestriction();
        };
    }
}
