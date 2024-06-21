//package com.example.drugsystem.config;
//
//
//import com.example.drugsystem.tool.MyAuthenticationFailureHandler;
//import com.example.drugsystem.tool.MyAuthenticationSuccessHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//        //如果不想加密就返回
////        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Bean
//    InMemoryUserDetailsManager userDetailsService() {
//
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        UserDetails user1 = User
//                .withUsername("123")
//                .password(passwordEncoder().encode("123"))
//                .roles("user")
//                .build();
//
//        manager.createUser(user1);
//        return manager;
//    }
//
//    //静态资源直接放行
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        //忽略这些静态资源（不拦截）
//        return (web) -> web.ignoring().requestMatchers("/js/**", "/css/**","/images/**");
//    }
//
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(
//                        request -> request
//                                .requestMatchers("/").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(
//                        form -> form
////                                .loginPage("/hello")
////                                .defaultSuccessURL("/homepage")
//                                .successHandler(myAuthenticationSuccessHandler())
//                                .failureHandler(myAuthenticationFailureHandler())
//                )
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    // 登录成功处理器
//    @Bean
//    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
//        return new MyAuthenticationSuccessHandler();
//    }
//
//    @Bean
//    public AuthenticationFailureHandler myAuthenticationFailureHandler(){
//        return new MyAuthenticationFailureHandler();
//    }
//
//    // 以下是CORS的具体配置
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        final CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*")); // 设置允许的源，"*"表示允许所有源
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // 设置允许的HTTP方法
//        configuration.setAllowCredentials(true); // 允许证书，不添加可能收到跨域请求问题
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "content-type", "x-auth-token")); //设置允许的header
////        configuration.setExposedHeaders(Arrays.asList("x-auth-token")); //如果使用JWT，需要额外配置这项
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration); // 对所有接口都使用该配置
//        return source;
//    }
//}
