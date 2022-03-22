package springboot.mission.community.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class SSOAuthFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(SSOAuthFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String queryString = httpServletRequest.getQueryString();
        if (queryString != null) {
            String[] parameters = queryString.split("&");
            for (String parameter : parameters) {
                String[] keyAndValue = parameter.split("=");
                if (keyAndValue[0].equals("likelion_login_cookie")) {
                    String token = keyAndValue[1];
                    Cookie cookie = new Cookie("likelion_login_cookie", token);
                    cookie.setPath("/");
                    httpServletResponse.addCookie(cookie);
                }
            }
        }

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("likelion_login_cookie")) {
                    logger.info("cookie: {}", cookie.getValue());
                    SecurityContextHolder.getContext().setAuthentication(
                            new Authentication() {
                                @Override
                                public Collection<? extends GrantedAuthority> getAuthorities() {
                                    return null;
                                }

                                @Override
                                public Object getCredentials() {
                                    return null;
                                }

                                @Override
                                public Object getDetails() {
                                    return null;
                                }

                                @Override
                                public Object getPrincipal() {
                                    return null;
                                }

                                @Override
                                public boolean isAuthenticated() {
                                    return false;
                                }

                                @Override
                                public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

                                }

                                @Override
                                public String getName() {
                                    return null;
                                }
                            }
                    );
                    break;
                }
            }
            logger.info("there is no cookie.");
        }

        chain.doFilter(request, response);
    }

}
