package com.example.bord.entitiy.pk;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// 2개의 키가 잡혀있어 클래스로 묶어주는 작업
public class FavoritePK implements Serializable {
    @Column(name = "board_number")
    private Integer boardNumber;
    @Column(name = "user_email")
    private String userEmail;
}
