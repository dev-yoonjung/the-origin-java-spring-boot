package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.mission.basic.model.dto.request.UserAPIRequest;
import springboot.mission.basic.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements BaseController<UserAPIRequest> {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<?> create(UserAPIRequest dto) {
        this.userService.create(dto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> read(Long id) {
        return ResponseEntity.ok(this.userService.read(id));
    }

    @Override
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(this.userService.readAll());
    }

    @Override
    public ResponseEntity<?> update(Long id, UserAPIRequest dto) {
        this.userService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        this.userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
