package com.mincheol.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// HTTP * localhost: 4000/request-data/**  로 받으려면 밑에 맵핑을 해줘야함
@RequestMapping("/request-data")
public class RequestDataController {
    
    // - @RequestParam() : GET, DELETE 처럼 URL로 데이터를 전송하는 메서드에서 Query String 으로 지정된 데이터를 가져오기 위해 사용 


    // HTTP GET localhost:4000/request-data/request-param
    @GetMapping("/request-param")



    // http://localhost:4000/request-data/request-param?userid=qwer@userName=gildong
    public String getRequestParam(
        @RequestParam(name="userId") String userid,
        @RequestParam(name="userName") String userName){
        return "사용자 아이디 :" + userid + "/ 사용자 이름 :" + userName;
    }

}
