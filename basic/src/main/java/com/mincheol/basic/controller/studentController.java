package com.mincheol.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mincheol.basic.dto.request.student.PatchStudentRequestDto;
import com.mincheol.basic.dto.request.student.postStudentRequestDto;
import com.mincheol.basic.service.implement.StudentServiceImplement;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student") // host:4400:/student 이런 식으로 받기 위해 지정
@RequiredArgsConstructor

// CRUD : create , read , update , delete 작업
public class studentController {

    private final StudentServiceImplement studentService;

    // CREATE

    @PostMapping("/")
    public ResponseEntity<String> postStudent(
            @RequestBody @Valid postStudentRequestDto requestBody) {
        ResponseEntity<String> response = studentService.postStudent(requestBody);
        return response;
    }

    // UPDATE
    @PatchMapping("/")
    public ResponseEntity<String> patchStudent(
            @RequestBody @Valid PatchStudentRequestDto requestBody) {
        ResponseEntity<String> response = studentService.patchStudent(requestBody);
        return response;
    }

    // DELETE
    @DeleteMapping("/{studentNumber}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable("studentNumber") Integer studentNumber) {
        ResponseEntity<String> response = studentService.deleteStudent(studentNumber);

        return response;
    }

}
