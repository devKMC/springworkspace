package com.example.bord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bord.repository.pk.FavoritePK;

@Repository
// favoriteEntity 엔티티에서 기본키가 INTEGER 와 STRING 으로 같이 잡혀 있어 클래스로 묶어준 다음 entity에서 클래스를 지정해주고 여기서 타입 지정(FavoritePK)
public interface FavoriteRepository extends JpaRepository<FavoriteRepository,FavoritePK> { 
    
}
