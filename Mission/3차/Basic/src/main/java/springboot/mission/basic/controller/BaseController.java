package springboot.mission.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BaseController<Request> {

    @PostMapping("")
    ResponseEntity<?> create(@RequestBody Request dto);

    @GetMapping("/{id}")
    ResponseEntity<?> read(@PathVariable Long id);

    @GetMapping("")
    ResponseEntity<?> readAll();

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @RequestBody Request dto);

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id);
}
