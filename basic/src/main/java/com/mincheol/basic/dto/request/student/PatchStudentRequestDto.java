package com.mincheol.basic.dto.request.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 어노테이션은 인자가 없는 기본 생성자를 자동으로 생성합니다.
public class PatchStudentRequestDto {
    @NotNull // 유효성 검사 어노테이션
    private Integer studentNumber;
    @NotBlank // 공백이나 빈문자열 등 오지 못하게 하는 어노테이션
    private String address;
}
