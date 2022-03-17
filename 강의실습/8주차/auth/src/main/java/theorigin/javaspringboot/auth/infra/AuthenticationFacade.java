package theorigin.javaspringboot.auth.infra;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
