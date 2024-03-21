package com.mincheol.basic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// get을 만들지 않으면 인식 못함

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// request Body로 받는 데이터에대한 유효성 검사를 vaildation 의존성을 추가해야함
public class SampleDto {

    // 해당 속성을 null이 올 수 없도록 지정
    @NotNull    
    private String notNull;

    // 문자열일 경우 null 또는 빈 문자열이 올 수없도록 지정
    @notEmpty  
    private String notEmpty;

    // 문자열일 경우 null 또는 빈 문자열 또는 공백으로된 문자열이 올 수 없도록 지정
    @NotBlank 
    private String notBlank;

    //RequestBody로 받아오는 데이터는 Wrapper 클래스 타입으로 데이터를 받는 것이 좋음
    @NotNull
    // NotEmpty, NotBlank 는 문자열에서만 유효함
    // @notEmpty @NotBlank // <-- empty , blank 는 유효하지 않는 검증 방법
    private Integer requiredint;

    // 문자열일 경우 문자열 길이의 최소 최대를 지정 (null 값이면 검사 안함)
    @Length (min=5 , max= 10)
    @NotNull
    private String length;

    @NotNull
    // 최대값과 최소값을 지정
    @Max(100)
    @Min(0)
    private Integer maxMin;

    //최대 최소 범위를 지정
    @NotNull
    @Range(min=0, max=100)
    private Integer range;

    //문자열이 이메일 형식인지 확인
    @NotNull
    @Email
    private String email;

    // 정규식을 이용해 문자열의 패턴 검사
    // 전화번호 , 이메일 , url , 주민등록번호 , 비밀번호 , 영어로만 된 문자열 , 한글로만된 문자열, 숫자로만된 문자열
    // email@email.com or email@email.co.kr
    // [] = 집합을 나타냄 , * = 무한으로 붙을 수 있다는걸 나타냄 , {} 범위를 지정함

    //여기서 안전한 패스워드는 "세가지 종류 이상의 문자구성으로 8자리 이상의 길이로 구성된 문자열" 또는 
    // "두가지 종류 이상의 문자구성으로 10자리 이상의 길이로 구성된 문자열"이다.
    // 문자구성의 종류는 로마자 알파벳 대문자와 소문자, 특수문자, 숫자, 4가지 범주를 조합하라는 설명이다.
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String emailPattern;
}

