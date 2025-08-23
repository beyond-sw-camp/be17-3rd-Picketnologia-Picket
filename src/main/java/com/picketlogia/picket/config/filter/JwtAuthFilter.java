package com.picketlogia.picket.config.filter;

import com.picketlogia.picket.api.user.model.dto.UserAuth;
import com.picketlogia.picket.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String jwt = null;

        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie: request.getCookies()) {

                // Cookie 리스트에 JWT 토큰이 있는지 확인
                if(cookie.getName().equals(JwtUtil.TOKEN_NAME)) {
                    jwt = cookie.getValue();
                    break;
                }
            }
        }

        if( jwt != null) {

            // JWT 토큰에 저장된 Claims 얻기
            Claims claims = JwtUtil.getClaims(jwt);

            if(claims!= null) {

                String email = JwtUtil.getValue(claims, JwtUtil.EMAIL_NAME);
                Long id = Long.parseLong(JwtUtil.getValue(claims, JwtUtil.IDX_NAME));
                String role = JwtUtil.getValue(claims, JwtUtil.ROLE_NAME);
                String userType = JwtUtil.getValue(claims, JwtUtil.USER_TYPE_NAME);

                UserAuth authUser = UserAuth.builder()
                        .idx(id)
                        .email(email)
                        .build();

                // Authentication 객체 생성
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        authUser,
                        null,
                        List.of(new SimpleGrantedAuthority(role), new SimpleGrantedAuthority(userType))
                );

                // SecurityContext에 Authentication 객체 저장
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
