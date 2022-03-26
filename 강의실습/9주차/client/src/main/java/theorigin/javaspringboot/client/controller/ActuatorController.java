package theorigin.javaspringboot.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theorigin.javaspringboot.client.service.ActuatorService;

@RestController
@RequestMapping("/actuator-api")
public class ActuatorController {

    private static final Logger logger = LoggerFactory.getLogger(ActuatorController.class);
    private final ActuatorService service;

    public ActuatorController(@Autowired ActuatorService service) {
        this.service = service;
    }

    @PostMapping("/logger/{loggerName}")
    public ResponseEntity<?> setLogLevel(@PathVariable String loggerName, @RequestParam String logLevel) {
        this.service.setServerLogLevel(loggerName, logLevel);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/shutdown")
    public ResponseEntity<?> shutdownServer() {
        this.service.shutdownServer();
        return ResponseEntity.noContent().build();
    }
}
