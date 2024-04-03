package com.example.board.service.implementations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.board.user.GetUserResponseDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import com.example.board.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    
    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {

        try{
        // 1. user 테이블에서 email에 해당하는 유저 조회   :데이터 베이스 작업임으로 레포지토리를 이용해야함
        // SELECT * FROM user WHERE email = email
        // findByEmail(email)
        // 2. (email -> (true, false) / (조회 결과 인스턴스) )
        UserEntity userEntity = userRepository.findByEmail(email);
        }catch (Exception exception){
        // 1-1 조회 처리 중 데이터베이스 관련 예외가 발생하면 데이터베이스 에러 응답 처리
        exception.printStackTrace();
        return ResponseDto.databaseError();
        }
        // 2- 1 조회 결과에 따라 반환 결정
        // 2- 2 false 이면 존재하지 않은 유저 응답처리
        // 2- 3 null  이면 존재하지 않은 유저 응답처리

        // 3. 조회 결과 데이터를 성공 응답
        // 3. 1 에러

    }
    
}