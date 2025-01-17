package com.green.eduuser.service;

import com.green.eduuser.dto.GoodsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
        String url = UriComponentsBuilder.fromHttpUrl(eduGoodsBaseUrl)
            .pathSegment("/api/v1/goods", goodsNo)  // /products/{goodsNo}
            .toUriString();

        // edu-goods API 호출
        return restTemplate.getForObject(url, GoodsDto.class);
    }
}