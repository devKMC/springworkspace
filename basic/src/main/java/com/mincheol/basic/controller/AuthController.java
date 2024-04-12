package com.mincheol.basic.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mincheol.basic.service.BasicService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {

    private final BasicService basicService;

    @GetMapping("/{principle}")
    public String getJwt (
        @PathVariable ("principle") String principle
    ){
        return basicService.getJwt(principle);
    }

    @PostMapping("/validation")
    public String jwtValidate(
        @RequestBody String jwt
    ){
        return basicService.jwtValidate(jwt);
    }

}