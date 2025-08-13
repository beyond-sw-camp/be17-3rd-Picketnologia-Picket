package com.picketlogia.picket.config.filter;

import com.picketlogia.picket.api.user.model.UserAuth;
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
        Cookie[] cookies = request.getCookies();
        String jwt = null;
        if(cookies != null) {
            for(Cookie cookie: request.getCookies()) {
                if(cookie.getName().equals(JwtUtil.TOKEN_NAME)) {
                    jwt = cookie.getValue();
                    break;
                }
            }
        }

        if( jwt != null) {
            Claims claims = JwtUtil.getClaims(jwt);
            if(claims!= null) {
                String email = JwtUtil.getValue(claims, JwtUtil.EMAIL_NAME);
                Long idx = Long.parseLong(JwtUtil.getValue(claims, JwtUtil.IDX_NAME));

                UserAuth authUser = UserAuth.builder()
                        .idx(idx)
                        .email(email)
                        .build();

                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        authUser,
                        null,
                        List.of(new SimpleGrantedAuthority("ROLE_USER")) // 특정 권한 부여, 권한 앞에 ROLE_를 붙여야 함
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);


            }
        }

        filterChain.doFilter(request, response);
    }
}
