package theorigin.javaspringboot.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import theorigin.javaspringboot.auth.infra.AuthenticationFacade;

@Controller
@RequestMapping("/home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final AuthenticationFacade authenticationFacade;

    public HomeController(@Autowired AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping
    public String name() {
        try {
            logger.info("connected user: {}",
                    this.authenticationFacade.getUsername());
        } catch (NullPointerException e) {
         logger.info("new user logged in");
        }
        return "index";
    }
}
