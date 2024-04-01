package com.example.bord.entitiy;

import com.example.bord.repository.pk.FavoritePK;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="favorite")
@Table(name="favorite")

@IdClass(FavoritePK.class) // FavoritePK.java 에서 묶은 클래스를 ID 클래스로 사용하는 지정
public class FavoriteEntity {
    @Id
    private Integer boardNumber;
    @Id
    private String userEmail;
}
