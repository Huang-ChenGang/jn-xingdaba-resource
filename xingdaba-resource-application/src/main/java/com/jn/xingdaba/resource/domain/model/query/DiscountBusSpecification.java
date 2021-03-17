package com.jn.xingdaba.resource.domain.model.query;

import com.jn.xingdaba.resource.api.DiscountBusRequestData;
import com.jn.xingdaba.resource.domain.model.DiscountBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.LocalTime;

@Slf4j
public class DiscountBusSpecification {
    public static Specification<DiscountBus> fromRequestData(DiscountBusRequestData requestData) {
        return (Specification<DiscountBus>) (root, query, cb) -> {
            log.info("discount bus query specification from request data: {}", requestData);
            Predicate finalConditions = cb.conjunction();
            if (requestData == null) {
                return finalConditions;
            }

            Path<LocalDate> dateBegin = root.get("dateBegin");
            Path<LocalDate> dateEnd = root.get("dateEnd");
            Path<LocalTime> timeBegin = root.get("timeBegin");
            Path<LocalTime> timeEnd = root.get("timeEnd");
            Path<String> busTypeName = root.get("busTypeName");
            Path<String> busNumber = root.get("busNumber");
            Path<String> driverName = root.get("driverName");
            Path<String> driverPhone = root.get("driverPhone");
            Path<String> parkAddr = root.get("parkAddr");
            Path<String> motorcade = root.get("motorcade");
            Path<String> district = root.get("district");
            Path<String> shelfState = root.get("shelfState");
            Path<String> isDelete = root.get("isDelete");

            if (requestData.getDateBegin() != null) {
                finalConditions = cb.and(finalConditions, cb.greaterThanOrEqualTo(dateBegin, requestData.getDateBegin()));
            }
            if (requestData.getDateEnd() != null) {
                finalConditions = cb.and(finalConditions, cb.lessThanOrEqualTo(dateEnd, requestData.getDateEnd()));
            }

            if (requestData.getTimeBegin() != null) {
                finalConditions = cb.and(finalConditions, cb.greaterThanOrEqualTo(timeBegin, requestData.getTimeBegin()));
            }
            if (requestData.getTimeEnd() != null) {
                finalConditions = cb.and(finalConditions, cb.lessThanOrEqualTo(timeEnd, requestData.getTimeEnd()));
            }

            if (StringUtils.hasText(requestData.getBusTypeName())) {
                finalConditions = cb.and(finalConditions, cb.like(busTypeName, "%" + requestData.getBusTypeName() + "%"));
            }

            if (StringUtils.hasText(requestData.getBusNumber())) {
                finalConditions = cb.and(finalConditions, cb.like(busNumber, "%" + requestData.getBusNumber() + "%"));
            }

            if (StringUtils.hasText(requestData.getDriverName())) {
                finalConditions = cb.and(finalConditions, cb.like(driverName, "%" + requestData.getDriverName() + "%"));
            }

            if (StringUtils.hasText(requestData.getDriverPhone())) {
                finalConditions = cb.and(finalConditions, cb.like(driverPhone, "%" + requestData.getDriverPhone() + "%"));
            }

            if (StringUtils.hasText(requestData.getParkAddr())) {
                finalConditions = cb.and(finalConditions, cb.like(parkAddr, "%" + requestData.getParkAddr() + "%"));
            }

            if (StringUtils.hasText(requestData.getMotorcade())) {
                finalConditions = cb.and(finalConditions, cb.like(motorcade, "%" + requestData.getMotorcade() + "%"));
            }

            if (StringUtils.hasText(requestData.getDistrict())) {
                finalConditions = cb.and(finalConditions, cb.equal(district, requestData.getDistrict()));
            }

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
