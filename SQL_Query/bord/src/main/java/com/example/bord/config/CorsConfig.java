package com.example.bord.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 스프링부트 설정과 관련된 파일
// add Cors mapping 부분을 작성
@Configuration
public class CorsConfig implements WebMvcConfigurer{
    @Override
    public void  addCorsMappings(CorsRegistry registry){
        registry
            // 어떤 request URL 패턴에 대하여 cors 정책을 지정할 건지 
            .addMapping("/**")
            // 해당 Request URL 패턴의 메서드에 Cors 정책을 허용할 건지
            .allowedMethods("*")
            //해당 Request URL 패턴의 어떤 출처에 cors 정책을 허용할 건지
            .allowedOrigins("*");
    }
}