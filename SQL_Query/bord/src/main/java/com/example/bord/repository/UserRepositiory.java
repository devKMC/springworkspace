package com.example.bord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bord.entitiy.UserEntity;

@Repository
public interface UserRepositiory extends JpaRepository<UserEntity,String> {
    
}
