package com.green.eduuser.service;

import com.green.eduuser.dto.GoodsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class EduGoodsClient {

    private final RestTemplate restTemplate;

    @Value("${edu-goods.base-url}")  // edu-goods의 base URL
    private String eduGoodsBaseUrl;

    public EduGoodsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GoodsDto getProductByProductNo(String goodsNo) {
        // edu-goods의 API URL
        String url = UriComponentsBuilder.fromUriString(eduGoodsBaseUrl)
            .path("/api/v1/goods/")
            .path(goodsNo)
            .toUriString();

        log.info("edu-goods 요청 경로: " + url);

        GoodsDto object = restTemplate.getForObject(url, GoodsDto.class);
        log.info(object.goodsName());

        // edu-goods API 호출
        return object;
    }
}