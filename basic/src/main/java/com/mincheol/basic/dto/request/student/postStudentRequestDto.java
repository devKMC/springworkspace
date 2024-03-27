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
public class postStudentRequestDto {

    @NotBlank //공백으로 지정할 수 없음
    private String name;

    @NotNull // INT NOT NULL 하면 안되기에 INTEGER
    @Min(0)  // 나이는 음수가 올 수 없기에 min 으로 지정
    private Integer age;

    @NotBlank
    private String address;

    @NotNull
    private Boolean graduation;
}
