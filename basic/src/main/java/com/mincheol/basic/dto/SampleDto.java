package com.mincheol.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// get을 만들지 않으면 인식 못함
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleDto {
    private String userId;
    private String UserPassword;
}
