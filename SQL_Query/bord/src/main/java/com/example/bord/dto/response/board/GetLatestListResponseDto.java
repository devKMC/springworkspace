package com.example.bord.dto.response.board;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.bord.dto.response.ResponseCode;
import com.example.bord.dto.response.ResponseDto;
import com.example.bord.dto.response.ResponseMessage;
import com.example.bord.dto.response.board.item.BoardListItem;

import lombok.Getter;

@Getter

public class GetLatestListResponseDto extends ResponseDto {
    private List<BoardListItem> latestList;

    private GetLatestListResponseDto( List<BoardListItem> latestList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = latestList;
    }
}

// 생성해주는 메서드 작업

public static ResponseEntity<GetLatestListResponseDto> success() {
    GetLatestListResponseDto response = new GetLatestListResponseDto(); // 인스턴스 작업
    return ResponseEntity.status(HttpStatus.OK).body(body);
}