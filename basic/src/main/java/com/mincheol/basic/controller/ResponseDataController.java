package com.mincheol.basic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mincheol.basic.dto.ResponseSampleDto;

import org.springframework.web.bind.annotation.RequestParam;


// 제이슨 형태를 반환하는 컨트롤러
@SuppressWarnings("unused")
@RestController

//HTTP * localhost:400/response-data/** 로 보여주려면 
@RequestMapping("/response-data")
public class ResponseDataController {
    //@ResponseEntity : 
    // - Response의 header , status code , status message , data를 조작할 수 있도록 하는 클래스 
    @GetMapping("/{number}")
    public ResponseEntity<String> getNumber(
         // 중괄호 안에 있는 것을 받으려면 pathvariable 사용
        @PathVariable("number")Integer number
    ){
        // 
        // String body = number > 0 ?"양수":number <0?"음수":"영";
        // return new ResponseEntity<>(body, HttpStatusCode.valueOf(400)); 방법 1 밑에 위에 둘다 사용 가능
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body); 방법 2
        // 
        ResponseEntity<String> response = null;
        if (number<0) 
        response = ResponseEntity.status(202).body("양수");
        if (number == 0) 
        response = ResponseEntity.status(201).body("양수");
        if (number >0)
        response = ResponseEntity.status(200).body("양수");
        return response;
    }

    @GetMapping("/response/dto")
    public ResponseEntity<ResponseSampleDto> getResponseDto() {
        ResponseEntity<ResponseSampleDto> response = ResponseEntity.status(201).body(new ResponseSampleDto("문자열", 99));
        return response;
    }
    
    
}


