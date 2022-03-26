package theorigin.javaspringboot.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import theorigin.javaspringboot.client.model.CarDTO;

@Service
public class CarAPIService {
    private static final Logger logger = LoggerFactory.getLogger(CarAPIService.class);
    private final WebClient randomDataClient;

    public CarAPIService(@Autowired WebClient randomDataClient) {
        this.randomDataClient = randomDataClient;
    }

    public CarDTO buyNewCar() {
        CarDTO result = this.randomDataClient
                .get()
                .uri("/api/vehicle/random_veihicle")
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.empty())
                .bodyToMono(CarDTO.class)
                .block();

        return result;
    }
}
