package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.mission.basic.controller.dto.AreaDTO;
import springboot.mission.basic.service.AreaService;

import java.util.Collection;

@RestController
@RequestMapping("/area")
public class AreaController {

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
    private final AreaService areaService;

    public AreaController(@Autowired AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping
    public ResponseEntity<AreaDTO> createArea(@RequestBody AreaDTO dto){
        return ResponseEntity.ok(this.areaService.createArea(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDTO> readArea(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.areaService.readArea(id));
    }

    @GetMapping
    public ResponseEntity<Collection<AreaDTO>> readAreaAll() {
        return ResponseEntity.ok(this.areaService.readAreaAll());
    }
}
