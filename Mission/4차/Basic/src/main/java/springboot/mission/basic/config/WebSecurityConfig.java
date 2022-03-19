package springboot.mission.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import springboot.mission.basic.handler.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(
            @Autowired AuthenticationProvider authenticationProvider,
            HttpSecurity http
            ) throws Exception {
        return http
                .authorizeRequests(
                        authorizeRequests -> {
                            authorizeRequests.antMatchers("/" , "/home/**", "/user/sign-up/**", "/h2-console/**").permitAll();
                            authorizeRequests.antMatchers("/shop/**").hasAuthority("ROLE_SHOP_OWNER");
                            authorizeRequests.anyRequest().authenticated();
                        }
                )
                .formLogin(
                        formLogin -> {
                            formLogin.loginPage("/user/login");
                            formLogin.permitAll();
                            formLogin.successHandler(successHandler());
                        }
                )
                .logout(
                        logout -> {
                            logout.logoutUrl("/user/logout");
                            logout.logoutSuccessUrl("/home");
                            logout.invalidateHttpSession(true);
                            logout.deleteCookies("JSESSIONID");
                        }
                )
                .authenticationProvider(authenticationProvider)
                .headers()
                .frameOptions()
                .disable()
                .addHeaderWriter(new StaticHeadersWriter("X-FRAME-OPTIONS", "ALLOW-FROM http://localhost:8080/h2-console"))
                .and()
                .csrf().disable()
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            @Autowired UserDetailsService userDetailsService,
            @Autowired PasswordEncoder passwordEncoder
            ) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new LoginSuccessHandler();
    }
}
