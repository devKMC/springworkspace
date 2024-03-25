package com.mincheol.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mincheol.basic.service.BasicService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
public class BasicController {

    // private BasicService service;

    // @autowirde
    // public BasicController (BasicService service){
    //     this.service = service;
    // }

    private final BasicService service;

    //HTTP GET localhost:4000/main/  <-- 까지 요청이 밑에 코드
    @RequestMapping(value="/", method = {RequestMethod.GET})
    public String getHello(){
        return "Hello Springboot!!";
    }
     //                                                                                      무조건 어떤걸 써야 한다는 것은 없음 기준은 잡기 나름

    // HTTP GET Method : 클라이언트가 서버로부터 데이터를 받기를 원할 때 사용하는 메서드           ex ) 유저정보 보기 , 로그인
    // HTTP POST Method : 클라이언트가 서버의 데이터를 작성하기를 원할 때 사용하는 메서드          ex ) 회원가입, 로그인(아이디 비밀번호 가릴때), 사원정보입력-전체사원 리스트받기(입력의 비중이 큼,따로 만들면 쉽게 분류 가능)
    // HTTP PUT Method : 클라이언트가 서버에 있는 리소스 전체를 수정하고 싶을 때 사용하는 메서드    ex ) 게시물 수정하기 , 게시물 좋아요(전체 삽입 , 전체 삭제)
    // HTTP PATCH Method : 클라이언트가 서버에 있는 리소스 일부를 수정하고 싶을 때 사용하는 메서드  ex ) 게시물 수정하기 
    // HTTP DELETE Method : 클라이언트가 서버에 있는 리소스를 삭제하고 싶을 때 사용하는 메서드      ex ) 회원탈퇴


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
    //@ PutMapping() : RequestMapping 기능을 put Method 한정시킨 것 (가독성 + 안정성)
    @PutMapping("/apple")
    public String putApple(){
        return "Put Mapping으로 만든 메서드";
    }
    //@PatchMapping() : RequestMapping 기능을 patch Method 한정시킨 것 (가독성 + 안정성)
    @PatchMapping("/apple")
    public String patchApple(){
        return "patch Mapping으로 만든 메서드";
    }
    //@DeleteMapping() : RequestMapping 기능을 delete Method 한정시킨 것 (가독성 + 안정성)
    @DeleteMapping("/apple")
    public String deleteApple(){
        return "delete Mapping으로 만든 메서드";
    }

    // Method - URL pattern이 중복되면 런타임 중에 에러가 발생
    // @DeleteMapping("/apple")
    // public String deleteApple1(){
    //     return "delete Mapping으로 만든 메서드";
    // }
}
