package com.jn.xingdaba.resource.application.service;

import com.jn.xingdaba.resource.api.BusTypeQueryRequestData;
import com.jn.xingdaba.resource.api.BusTypeRecommendResponseData;
import com.jn.xingdaba.resource.application.dto.BusTypeResponseDto;
import com.jn.xingdaba.resource.application.dto.BusTypeSaveRequestDto;
import com.jn.xingdaba.resource.domain.model.BusPrice;
import com.jn.xingdaba.resource.domain.model.BusType;
import com.jn.xingdaba.resource.domain.service.BusPriceDomainService;
import com.jn.xingdaba.resource.domain.service.BusTypeDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BusTypeServiceImpl implements BusTypeService {
    private final BusTypeDomainService domainService;
    private final BusPriceDomainService busPriceDomainService;

    public BusTypeServiceImpl(BusTypeDomainService domainService,
                              BusPriceDomainService busPriceDomainService) {
        this.domainService = domainService;
        this.busPriceDomainService = busPriceDomainService;
    }

    @Override
    public Page<BusTypeResponseDto> findAll(BusTypeQueryRequestData requestData) {
        log.info("find pageable bus type request data: {}", requestData);
        Pageable pageable = PageRequest.of(requestData.getPageNo(), requestData.getPageSize());
        return domainService.findAll(requestData, pageable)
                .map(BusTypeResponseDto::fromModel);
    }

    @Override
    public String save(BusTypeSaveRequestDto requestDto) {
        log.info("save bus type request dto: {}", requestDto);
        return domainService.save(BusTypeSaveRequestDto.toModel(requestDto));
    }

    @Override
    public void deleteOrRestore(String ids) {
        log.info("delete or restore bus type for: {}", ids);
        domainService.deleteOrRestore(Arrays.asList(ids.split(",")));
    }

    @Override
    public List<BusTypeResponseDto> findAll() {
        return domainService.findAll().stream()
                .map(BusTypeResponseDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<BusTypeRecommendResponseData> recommendBusType(Integer passengerNumber) {
        List<BusTypeRecommendResponseData> recommendBusTypeList = new ArrayList<>();

        List<BusType> busTypeList = domainService.findAll();

        // 车型对应车价
        Map<Integer, BigDecimal> busPriceMap = new HashMap<>();

        // 判断是否超过系统库内最大车型
        for (BusType busType : busTypeList) {
            if (busType.getSeatNum() >= passengerNumber) {
                BusTypeRecommendResponseData recommendBusType = new BusTypeRecommendResponseData();
                BeanUtils.copyProperties(busType, recommendBusType);
                recommendBusType.setBusCount(1);
                recommendBusTypeList.add(recommendBusType);
                return recommendBusTypeList;
            }

            // 获取车价信息
            BusPrice busPrice = busPriceDomainService.findByBusTypeId(busType.getId());
            log.info("find bus price info: {}", busPrice);
            busPriceMap.put(busType.getSeatNum(), busPrice.getCost());
        }

        // 获取推荐车型
        Map<String, String> recommendMap = get(busPriceMap, passengerNumber);
        String recommendType = recommendMap.get("busList");
        Map<Integer, Integer> map = new HashMap<>();
        for (String type : recommendType.split("&")) {
            Integer key = Integer.parseInt(type);
            if (map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }

        // 设置车型ID
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (BusType busType : busTypeList) {
                if (busType.getSeatNum().equals(entry.getKey())) {
                    BusTypeRecommendResponseData recommendBusType = new BusTypeRecommendResponseData();
                    BeanUtils.copyProperties(busType, recommendBusType);
                    recommendBusType.setBusCount(entry.getValue());
                    recommendBusTypeList.add(recommendBusType);
                }
            }
        }

        return recommendBusTypeList;
    }

    @Override
    public List<BusTypeResponseDto> findByIds(String ids) {
        log.info("find bus type list by ids: {}", ids);
        return domainService.findAllByIdIn(Arrays.asList(ids.split(",")))
                .stream().map(BusTypeResponseDto::fromModel)
                .collect(Collectors.toList());
    }

    private Map<String, String> get(Map<Integer, BigDecimal> busTypeMap, int personNum) {
        Map<String, String> retMap = getMinPrice(busTypeMap, personNum);

        Map<Integer, Map<String, String>> memberMap = new HashMap<>();

        while (new BigDecimal(retMap.get("minPrice")).compareTo(BigDecimal.ZERO)==0) {
            personNum += 1;

            // 记忆功能
            if (memberMap.containsKey(personNum)) {
                retMap = memberMap.get(personNum);
            } else {
                retMap = getMinPrice(busTypeMap, personNum);
            }

            memberMap.put(personNum, retMap);
        }

        return retMap;
    }

    private Map<String, String> getMinPrice(Map<Integer, BigDecimal> busTypeMap, int personNum) {
        Map<String, String> retMap = new HashMap<>();
        retMap.put("minPrice", String.valueOf(BigDecimal.ZERO));
        retMap.put("busList", "");

        if (personNum == 0 || busTypeMap == null || busTypeMap.size() == 0) {
            return retMap;
        }

        // 各个人数对应的最低车价
        BigDecimal[] minPriceArr = new BigDecimal[personNum + 1];
        Arrays.fill(minPriceArr, BigDecimal.ZERO);

        Map<Integer, String> map = new HashMap<>();

        for (Map.Entry<Integer, BigDecimal> entry : busTypeMap.entrySet()) {
            int busTypeNum = entry.getKey();
            BigDecimal busPrice = entry.getValue();

            // 正序遍历，由底向上
            for (int i = busTypeNum; i <= personNum; i++) {

                // 最小车价计算
                if (i == busTypeNum) {
                    minPriceArr[i] = busPrice;

                    map.put(i, String.valueOf(busTypeNum));
                } else if (minPriceArr[i].compareTo(BigDecimal.ZERO)==0 && minPriceArr[i - busTypeNum].compareTo(BigDecimal.ZERO)!=0) {
                    minPriceArr[i] = minPriceArr[i - busTypeNum].add(busPrice);

                    if (map.containsKey(i - busTypeNum)) {
                        map.put(i, map.get(i - busTypeNum).concat("&").concat(String.valueOf(busTypeNum)));
                    } else {
                        map.put(i, String.valueOf(busTypeNum));
                    }

                } else if (minPriceArr[i - busTypeNum].compareTo(BigDecimal.ZERO) != 0) {

                    if (minPriceArr[i].compareTo((minPriceArr[i - busTypeNum].add(busPrice))) > 0) {
                        minPriceArr[i] = (minPriceArr[i - busTypeNum].add(busPrice));

                        if (map.containsKey(i - busTypeNum)) {
                            map.put(i, map.get(i - busTypeNum).concat("&").concat(String.valueOf(busTypeNum)));
                        } else {
                            map.put(i, String.valueOf(busTypeNum));
                        }
                    }

                }

            }
        }

        BigDecimal minPrice = minPriceArr[personNum];

        if (minPrice.compareTo(BigDecimal.ZERO) > 0) {
            retMap.put("minPrice", String.valueOf(minPrice));
            retMap.put("busList", map.get(personNum));
        }

        return retMap;
    }
}
