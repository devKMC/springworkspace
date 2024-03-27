package com.mincheol.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mincheol.basic.dto.request.student.postStudentRequestDto;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/student") // host:4400:/student 이런 식으로 받기 위해 지정

// CRUD : create , read , update , delete 작업
public class studentController {
    
    // CREATE
    @PostMapping("/")
    public ResponseEntity<String>  postStudent(  // RESPONSE 데이터 타입을 제너릭 전달  
        @RequestBody @Valid postStudentRequestDto RequestBody
    ){
        return null;
    }

    // UPDATE
    @PatchMapping("/")
    public ResponseEntity<?> patchStudent(){
        return null;
    }

    // DELETE
    @DeleteMapping("/{studentNumber}")
    public ResponseEntity<?> deleteStudent(
        @PathVariable("studentNumber") Integer studentNumber
    ){
        return null;
    }

}

