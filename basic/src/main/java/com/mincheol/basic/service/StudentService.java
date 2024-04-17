package com.mincheol.basic.service;

import org.springframework.http.ResponseEntity;

import com.mincheol.basic.dto.request.student.PatchStudentRequestDto;
import com.mincheol.basic.dto.request.student.PostStudentRequestDto;
import com.mincheol.basic.dto.request.student.SignInRequestDto;


public interface StudentService {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
    ResponseEntity<String> patchStudent(PatchStudentRequestDto dto);
    ResponseEntity<String> deleteStudent(Integer studentNumber);
    ResponseEntity<String> signIn(SignInRequestDto dto);
}