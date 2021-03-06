package theorigin.javaspringboot.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import theorigin.javaspringboot.auth.infra.CustomUserDetailsService;
import theorigin.javaspringboot.auth.infra.NaverOAuth2Service;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final NaverOAuth2Service naverOAuth2Service;

    public WebSecurityConfig(@Autowired CustomUserDetailsService customUserDetailsService,
                             @Autowired NaverOAuth2Service naverOAuth2Service) {
        this.naverOAuth2Service = naverOAuth2Service;
        this.userDetailsService = customUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password(passwordEncoder().encode("user1password"))
//                .roles("USER")
//                .and()
//                .withUser("admin1")
//                .password(passwordEncoder().encode("admin1password"))
//                .roles("ADMIN");
        auth.userDetailsService(this.userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/home/**", "/user/signup/**")
                    .anonymous()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                        .userService(this.naverOAuth2Service)
                    .and()
                        .defaultSuccessUrl("/home")
                .and()
                    .logout()
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/home")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .permitAll();
    }
}
