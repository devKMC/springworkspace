package com.mincheol.basic.service.implement;

import org.springframework.stereotype.Service;

import com.mincheol.basic.service.BasicService;

// Service 레이어 :
// - 실제 비즈니스 로직(연산)을 실행하는 영역
// - 트랜젝션 처리나 유효성 검사(직전 비즈니스 로직 결과에 대한)를 수행하기도 함
// Controller로부터 받은 요청 데이터에 대해서 필요에 따라 Repository 등을 거쳐 연산을 진행하고 Controller에 응답에 대한 데이터를 반환
@Service
public class BasicServiceImplement implements BasicService{

    @Override
    public String getHello() {
        return "hello Springboot!!";
    }

    @Override
    public String getApple() {
        return "get Mapping으로 만든 메서드";
    }
    
}
