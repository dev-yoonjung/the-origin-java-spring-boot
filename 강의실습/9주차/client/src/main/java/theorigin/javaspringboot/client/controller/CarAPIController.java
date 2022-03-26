package theorigin.javaspringboot.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theorigin.javaspringboot.client.model.CarDTO;
import theorigin.javaspringboot.client.service.CarAPIService;

import java.util.List;

@RestController
@RequestMapping("/random-data")
public class CarAPIController {

    private final CarAPIService service;

    public CarAPIController(@Autowired CarAPIService service) {
        this.service = service;
    }

    @PostMapping("/buy-car")
    public CarDTO buyCar() {
        return this.service.buyNewCar();
    }

//    @GetMapping("/show-cars")
//    public List<CarDTO> getCars() {
//        return this.service.getCarsOwned();
//    }

}
