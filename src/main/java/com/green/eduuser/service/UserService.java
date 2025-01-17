package com.green.eduuser.service;

import com.green.eduuser.dto.GoodsDto;
import com.green.eduuser.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final EduGoodsClient eduGoodsClient;

    public UserService(EduGoodsClient eduGoodsClient) {
        this.eduGoodsClient = eduGoodsClient;
    }

    public UserDto getUserByUserNo(String userNo) {
        // 사용자 데이터를 생성
        GoodsDto goodsDto = eduGoodsClient.getProductByProductNo("1");

        return new UserDto(userNo, "random name", goodsDto);
    }

}
