package com.mincheol.basic.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mincheol.basic.filter.JwtAuthenticationFilter;
import com.mincheol.basic.service.implement.OAuthUserServiceImplement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
// @Configurable:
// - 생성자나 '메서드'가 호출시에 Spring bean 등록을 자동화(제어 역전) 하는 어노테이션
@Configurable
// @EnableWebSecurity:
// - Web Securirity 설정을 지원하도록 하는 어노테이션
@EnableWebSecurity
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final OAuthUserServiceImplement oAuth2UserService;

    // @Bean :
    // - Spring bean으로 등록하는 어노테이션
    // - @Component를 사용하지 못할 때 사용
    // - @Autowired의 목적이 아닐 때 사용
    @Bean
    protected SecurityFilterChain configure(HttpSecurity security) throws Exception {
        // class :: method :
        // - 메소드 참조 , 특정 클래스의 메서드를 참조할 때 사용
        // - 일반적으로 매개변수로 메서드를 전달할 때 사용됨
        security
        // basic authentication 미사용 지정
        .httpBasic(HttpBasicConfigurer::disable)
        // session :
        // - 웹 애플리케이션에서 사용자의 대한 정보 및 상태를 유지하기 위한 기술
        // - 서버측에서 사용자 정보 및 상태를 저장하는 방법
        // - REST API 서버에서는 session 사용자 정보 및 상태를 클라이언트가 유지하기 때문에 session을 생성하지 않음

        //  cokie :
        // - 웹 에플리케이션에서 사용자에 대한 정보 및 상태를 유지하기 위한 기술
        // - 클라이언트측에서 사용자 정보 및 상태를 저장하는 방법

        // session 과 cookie의 차이 :
        // - 저장위치 다름 cookie는 클라이언트 , session은 서버
        // - 보안 : Sessoin이 보안 수준이 높음
        // - 수명 : cookie 지정한 기간동안 지속적으로 유지, session은 연결이 끊기면 파기됨
        // - 용도 : cookie에는 간단한 데이터 (id,token)를 저장 , session에는 민감한 데이터 (개인정보)를 저장      

        // cashe:
        // - 데이터나 값을 미리 복사해두고 저장하는 임시 공간
        // - 사용자의 접근을 조금 더 빠르게 할 수 있도록 함
        // - 시스템 성능 향상
        // - 하드웨어 캐시 : cpu cache, disk cache
        // - 소프웨어 캐시 : web cache, database cache
        // - 네트워크 캐시 : CDN
        // - SQL Injection :
        // - 공격자가 데이터베이스의 쿼리 문을 직접 조작하여 데이터를 탈취하는 공격
        // XSS (cross-Site Scripting) :
        // - 공격자가 웹 브라우저에 악성 스크립트를 작성하여 실행시키는 공격
        .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf(CsrfConfigurer::disable)
        // Spring security 사용 이후에는 CORS 정책을 Security Filter Chain에 등록
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))

        // 요청 URL의 패턴에 따라 리소스접근 허용 범위를 지정
        // 인증 되지 않은 사용자도 접근을 허용
        // 인증된 사용자 중 특정 권한을 가지고 있는 사용자만 접근을 허용
        // 인증된 사용자는 모두 접근을 허용
        .authorizeHttpRequests(request -> request
        .requestMatchers("/oauth2/**").permitAll()
        // 특정 URL 패턴에 대한 요청은 인증되지 않은 사용자도 접근을 허용
        .requestMatchers(HttpMethod.GET,"/auth/*/").permitAll()
        // 특정 URL 패턴에 대한 요청은 지정한 권한을 가지고 있는 사용자만 접근을 허용
        // .requestMatchers("/student/**").hasRole("STUDENT")
        .requestMatchers("/student", "/student/**").permitAll()
        // 인증된 사용자는 모두 접근을 허용
        .anyRequest().authenticated()
        )
        // OAuth 인증 서버에서 redirection 하는 URL 과정
        .oauth2Login(oauth2 -> oauth2
        .redirectionEndpoint(endpoint -> endpoint.baseUri("/oauth2/callback/*"))
        // OAuth 인증 서버에서 인증 절차가 끝난 후 사용자에 대한 정볼르 처리하는 객체를 지정
        .userInfoEndpoint(endpoint -> endpoint.userService(oAuth2UserService)))
        // 인증 과정중에 발생한 예외처리
        .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(new failedAuthorizationEntryPoint()));

        // CSRF (cross-Site Request forgery)
        // - 클라이언트 (사용자)가 자신의 의도와는 무관한 공격행위를 하는 것

        // 우리가 생성한 jwtAuthenticationFilter 를 UsernamePasswordAuthenticationFilter 이전에 등록
        security.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
        return security.build();
    }

    protected CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedMethod("*");
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}

// 인증 실패 처리를 위한 커스텀 예외 처리 (AuthenticationEntryPoint 인터페이스 구현)
class failedAuthorizationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

                authException.printStackTrace();
                
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("{\"message\":\"인증에 실패했습니다\"}");
    }
    
}



// * ==========================================================================================

// 코드 해석 

// public class WebSecurityConfig {

//     private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // Spring Security 필터 체인을 정의하는 메서드
//     @Bean
//     protected SecurityFilterChain configure(HttpSecurity security) throws Exception {
//         security
            // 기본 HTTP 기본 인증을 사용하지 않도록 설정
//             .httpBasic(HttpBasicConfigurer::disable)
            // 세션 관리 정책 설정
//             .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // CSRF 보호 설정 비활성화
//             .csrf(CsrfConfigurer::disable)
            // CORS 설정 적용
//             .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            // 요청에 대한 인가 정책 설정
//             .authorizeHttpRequests(request -> request
                // 특정 URL 패턴에 대한 GET 요청은 인증 없이 허용
//                 .requestMatchers(HttpMethod.GET, "/auth/*").permitAll()
                // "/student/**" 패턴의 요청은 "STUDENT" 권한을 가진 사용자만 허용
//                 .requestMatchers("/student/**").hasRole("STUDENT")
                // 그 외의 요청은 인증된 사용자만 허용
//                 .anyRequest().authenticated()
//             )
            // 인증 실패 처리를 위한 커스텀 예외 처리기 설정
//             .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(new FailedAuthorizationEntryPoint()));

        // JWT 인증 필터를 UsernamePasswordAuthenticationFilter 앞에 추가
//         security.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        // 설정된 보안 설정 반환
//         return security.build();