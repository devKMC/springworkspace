package com.mincheol.basic.service.implement;

import org.springframework.stereotype.Service;

import com.mincheol.basic.provider.JwtProvider;
import com.mincheol.basic.service.BasicService;

import lombok.RequiredArgsConstructor;

// Service 레이어 :
// - 실제 비즈니스 로직(연산)을 실행하는 영역
// - 트랜젝션 처리나 유효성 검사(직전 비즈니스 로직 결과에 대한)를 수행하기도 함
// Controller로부터 받은 요청 데이터에 대해서 필요에 따라 Repository 등을 거쳐 연산을 진행하고 Controller에 응답에 대한 데이터를 반환

// @Service : 해당 클래스를 Spring Bean으로 등록하는 어노테이션, 역활은 @Component와 동일
// @component : 해당 클래스를 Spring Bean으로 등록하는 어노테이션 
// @Spring Been : 제어의 역전을 통해서 의존성 주입시 해당 클래스의 인스턴스를  Spring Framework가 제어하는 요소

@Service
@RequiredArgsConstructor
public class BasicServiceImplement implements BasicService {

    private final JwtProvider jwtProvider;

    @Override
    public String getHello() {
        return "hello Springboot!!";
    }

    @Override
    public String getApple() {
        return "get Mapping으로 만든 메서드";
    }

    @Override
    public String getJwt(String priciple) {
        return jwtProvider.create(priciple);
    }

    @Override
    public String jwtValidate(String jwt) {
        return jwtProvider.validation(jwt);
    }

}
