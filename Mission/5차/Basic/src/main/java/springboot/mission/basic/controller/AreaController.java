package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.mission.basic.controller.dto.AreaDto;
import springboot.mission.basic.service.AreaService;

import java.util.Collection;

@RestController
public class AreaController {
    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/area")
    public ResponseEntity<AreaDto> createArea(@RequestBody AreaDto dto){
        return ResponseEntity.ok(this.areaService.createArea(dto));
    }

    @GetMapping("/area/{id}")
    public ResponseEntity<AreaDto> readArea(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.areaService.readArea(id));
    }

    @GetMapping("/area")
    public ResponseEntity<Collection<AreaDto>> readAreaAll() {
        return ResponseEntity.ok(this.areaService.readAreaAll());
    }

    @GetMapping("/get-location-info")
    public ResponseEntity<AreaDto> getNearestPlace(@RequestParam Double latitude,
                                                   @RequestParam Double longitude) {
        return ResponseEntity.ok(this.areaService.getNearestPlace(latitude, longitude));
    }
}
