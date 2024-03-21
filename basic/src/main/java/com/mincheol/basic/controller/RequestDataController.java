package com.mincheol.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mincheol.basic.dto.SampleDto;

import jakarta.validation.Valid;

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
        @RequestParam(name="userName" ,required = false) String userName,   //required = false 를 사용해 필수가 아님을 나타냄
        @RequestParam() int userAge
        ){
        return "사용자 아이디 :" + userid + "/ 사용자 이름 :" + userName + "/ 사용자 나이 :" + userAge;
    }

    // @pathVariable() : 
    // 모든 HTTP 메서드에서 URL의 특정 패턴에 따라서 데이터를 추출하는 방식
    // HTTP DELETE localhost:4000/request-data/path-variable
    // "/path-variable/{age}/{name}"
    @DeleteMapping({
        "/path-variable/{age}/{name}",
        "/path-variable/{age}"
    })
    //http://localhost:4000/request-data/path-variable/10
    public String deletePathVariable(
        @PathVariable("age") Integer age,
        @PathVariable(name = "name", required = false) String name
    ){
        return "사용자 나이 :" + age + " / 사용자이름 : " + name;
    }

    // HTTP PATCH localhost:4000/request-data/patch/gildong/update
    @PatchMapping("/patch/{userName}/update")
    public String patchUpdate(
        @PathVariable("userName") String userName
    ){
        return "사용자이름: " + userName;
    }

    //!  ************주의***************
    // URL 패턴으로 데이터를 받아오는 방식을 썼을 때 
    // 겹치는 패턴이 존재하는지 잘 확인해야 함
    @GetMapping("/{value}/get")
    public String getPathVariable1(
        @PathVariable("value") String value
    ){
        return "";
    }

    @GetMapping("/get/{value}")
    public String getPathVariable2(
        @PathVariable("value") String value
    ){
        return "";
    }
    //@RequestBody()
    // - POST , PATCH , PUT 처럼 RequestBody로 데이터를 전송하는 메서드에서 데이터를 가져오기 위해 사용
    // HTTP POST localhost:4000/request-data/post
    @PostMapping("/post")
    public String post(
        // @RequestBody String text
        // @valid : 해당 payload에 대해서 유효성 검사를 실시하도록 함
        @RequestBody @Valid SampleDto dto

    ){
        return "전송한 데이터:" + dto.toString();
    }
}
