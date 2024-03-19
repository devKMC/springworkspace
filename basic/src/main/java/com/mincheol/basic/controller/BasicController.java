package com.mincheol.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller 레이어 :
// - 클라이언트의 서버간의 접점
// - 클라이언트의 요청을 받고 해당 요청에 대한 응답을 클라이언트에 돌려주는 영역
// - 각 요청에 해당하는 URL 메서드를 작성하는 영역


// @Resutcontroller : JSON 형태의 responseBody를 반환하는 컨트롤러 임을 명시
// @RestController = @controller + @responseBody
@RestController

// @RequestMappint() : HTTP 요청에 클래스와 메서드를 매핑하기 위한 어노테이션
// @RequestMapping(value ="/main", method= {RequestMethod.GET})
// HTTP GET localhost:4000/main/**
@RequestMapping("/main")
public class BasicController {

    //HTTP GET localhost:4000/main/  <-- 까지 요청이 밑에 코드
    @RequestMapping(value="/", method = {RequestMethod.GET})
    public String getHello(){
        return "Hello Springboot!!";
    }

    //@ GetMapping() : RequestMapping 기능을 GET Mathod에 한정시킨 것 (가독성 + 안정성)
    @GetMapping("/apple")
    public String getApple(){
        return "Get Mapping으로 만든 메서드";
    }
    //@ PostMapping() : RequestMapping 기능을 Post Method 한정시킨 것 (가독성 + 안정성)
    @PostMapping("/apple")
    public String postApple(){
        return "Post Mapping으로 만든 메서드";
    }
}
