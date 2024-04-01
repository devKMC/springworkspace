package com.example.bord.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="board")
@Table(name="bord")

public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNumber;
    private String title;
    private String contets;
    private String imageUrl;
    private Integer viewCount;
    private Integer commentCount;
    private Integer favoriteCount;
    private String writeDatetime; // 문자열로 받는게 좋음
    private String writerEmail;
}
