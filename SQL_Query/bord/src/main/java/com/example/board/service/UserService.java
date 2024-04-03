package com.example.board.service;
import com.example.board.dto.response.board.user.GetUserResponseDto;

import org.springframework.http.ResponseEntity;

public interface UserService {
    
    ResponseEntity<? super GetUserResponseDto> getUser(String email);

}