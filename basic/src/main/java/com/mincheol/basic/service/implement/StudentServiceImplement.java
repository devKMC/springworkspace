package com.mincheol.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mincheol.basic.dto.request.student.postStudentRequestDto;
import com.mincheol.basic.entity.StudentEntity;
import com.mincheol.basic.repository.studentRepository;
import com.mincheol.basic.service.studentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImplement implements studentService{



    private final studentRepository studentRepository;
    @Override
    public ResponseEntity<String> postStudent(postStudentRequestDto dto) {

         // 1. Entity 클래스의 인스턴스 생성
         // 2. 생성한 인스턴스를 repository.save() 메서드로 저장
        StudentEntity studentEntity = new StudentEntity(dto); // 생성자로 레코드를 생성
        // save() : 저장 및 수정 (덮어쓰기)
        StudentEntity saveEntity= studentRepository.save(studentEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body("성공");
    }
    
}


