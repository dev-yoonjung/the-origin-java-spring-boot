package springboot.mission.community.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping
    public String index() {
        return "redirect:home";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
