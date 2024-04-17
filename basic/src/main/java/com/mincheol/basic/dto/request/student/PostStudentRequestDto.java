package com.mincheol.basic.dto.request.student;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 디폴트 생성자를 생성


// USER를 만들기 위해 작업
public class PostStudentRequestDto {
    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Integer age;

    @NotBlank
    private String address;
    
    @NotNull
    private Boolean graduation;

    @NotBlank
    private String password;

}