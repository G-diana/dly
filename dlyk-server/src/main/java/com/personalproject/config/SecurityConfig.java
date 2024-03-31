package com.personalproject.config;

import com.personalproject.config.handler.MyAuthenticationFailureHandler;
import com.personalproject.config.handler.MyAuthenticationSuccessHandler;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class SecurityConfig {
    @Resource
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Resource
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Bean  //There is no PasswordEncoder mapped for the id "null",需要配加密器
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,CorsConfigurationSource configurationSource) throws Exception{
        //禁用跨站请求伪造
        return httpSecurity
                .formLogin( (formLogin)-> {
                    formLogin.loginProcessingUrl("/api/login")//登录处理地址不需要写controller
                            .usernameParameter("loginAct")
                            .passwordParameter("loginFwd")
                            .successHandler(myAuthenticationSuccessHandler)
                            .failureHandler(myAuthenticationFailureHandler);

                })

                .authorizeHttpRequests( (authorize) -> {
                    authorize.requestMatchers("/api/login").permitAll()
                            .anyRequest().authenticated();//其他任何请求都需要登录后才能访问
                })
                .csrf(AbstractHttpConfigurer::disable)//方法引用：关闭跨域请求保护,禁用跨站请求伪造

                //支持跨域请求
                .cors((cors)->{
                    cors.configurationSource(configurationSource);
                })

                .build();
    }

    @Bean
    public CorsConfigurationSource configurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); //允许任何来源，http://localhost:8081
        configuration.setAllowedMethods(Arrays.asList("*")); //允许任何请求方法，post、get、put、delete
        configuration.setAllowedHeaders(Arrays.asList("*")); //允许任何的请求头

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
