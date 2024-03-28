package com.mincheol.basic.service;

import org.springframework.http.ResponseEntity;

import com.mincheol.basic.dto.request.student.PatchStudentRequestDto;
import com.mincheol.basic.dto.request.student.postStudentRequestDto;

public interface studentService {
    ResponseEntity<String> postStudent(postStudentRequestDto dto);
    ResponseEntity<String> patchStudent(PatchStudentRequestDto dto);
    ResponseEntity<String> deleteStudent(Integer studentNumber);
}