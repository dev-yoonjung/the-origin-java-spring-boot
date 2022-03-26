package theorigin.javaspringboot.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import theorigin.javaspringboot.client.model.ActuatorLoggerDTO;

@Service
public class ActuatorService {

    private static final Logger logger = LoggerFactory.getLogger(ActuatorService.class);
    private final WebClient actuatorClient;

    public ActuatorService(@Autowired WebClient actuatorClient) {
        this.actuatorClient = actuatorClient;
    }

    public void setServerLogLevel(String loggerName, String logLevel) {
        String uri = String.format("/loggers/%s", loggerName);
        ResponseEntity<?> bodiless = this.actuatorClient
                .post()
                .uri(uri)
                .bodyValue(new ActuatorLoggerDTO(logLevel))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                    logger.error(clientResponse.statusCode().toString());
                    return Mono.empty();
                })
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                    Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)))
                .toBodilessEntity() // HTTP Response Body
                .block();
    }

    public void shutdownServer() {
        String uri = "/shutdown";
        ResponseEntity<?> bodiless = this.actuatorClient
                .post()
                .uri(uri)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                    Mono.error(new ResponseStatusException(clientResponse.statusCode())))
                .toBodilessEntity()
                .block();
    }
}
