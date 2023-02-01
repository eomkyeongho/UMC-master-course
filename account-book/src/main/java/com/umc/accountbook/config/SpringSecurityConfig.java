package com.umc.accountbook.config;

import com.umc.accountbook.role.Role;
import com.umc.accountbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {
    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/goal/**").hasRole(Role.USER.name())
                .antMatchers("/expenditure/**").hasRole(Role.USER.name())
                .antMatchers("/history/**").hasRole(Role.USER.name())
                .antMatchers("/user/**").hasRole(Role.USER.name())
                .antMatchers("/essential-spending/**").hasRole(Role.USER.name())
                .anyRequest().authenticated().and()
                .logout().logoutSuccessUrl("/").and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(userService);

        return http.build();
    }
}