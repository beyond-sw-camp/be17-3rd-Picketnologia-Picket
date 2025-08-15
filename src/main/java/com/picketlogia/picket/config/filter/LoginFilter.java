package com.picketlogia.picket.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.picketlogia.picket.api.user.model.UserAuth;
import com.picketlogia.picket.api.user.model.UserLogin;
import com.picketlogia.picket.api.user.model.UserLoginResp;
import com.picketlogia.picket.common.model.BaseResponse;
import com.picketlogia.picket.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authToken;
        try {

            UserLogin dto = new ObjectMapper().readValue(request.getInputStream(), UserLogin.class);
            authToken = new UsernamePasswordAuthenticationToken(
                    dto.getEmail(), dto.getPassword(), null
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return authenticationManager.authenticate(authToken);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserAuth authUser = (UserAuth) authResult.getPrincipal();

        String jwt = JwtUtil.generateToken(authUser.getEmail(), authUser.getIdx());

        if(jwt != null) {
            Cookie cookie = new Cookie(JwtUtil.TOKEN_NAME, jwt);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(
                    new ObjectMapper().writeValueAsString(
                            BaseResponse.success(UserLoginResp.from(authUser))
                    )
            );
        }


    }
}
