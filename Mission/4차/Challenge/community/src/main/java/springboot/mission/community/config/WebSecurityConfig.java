package springboot.mission.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests(authorizedRequests -> {
                    authorizedRequests.antMatchers("/", "/home/**").permitAll();
                    authorizedRequests.anyRequest().authenticated();
                })
                .logout(logout -> {
                    logout.logoutUrl("/user/logout");
                    logout.logoutSuccessUrl("/home");
                    logout.deleteCookies("likelion_login_cookie");
                    logout.invalidateHttpSession(true);
                })
                .build();
    }
}
