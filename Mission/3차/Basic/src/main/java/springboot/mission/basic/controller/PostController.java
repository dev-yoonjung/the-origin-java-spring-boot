package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.mission.basic.model.dto.request.PostAPIRequest;
import springboot.mission.basic.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController implements BaseController<PostAPIRequest> {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<?> create(PostAPIRequest dto) {
        this.postService.create(dto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> read(Long id) {
        return ResponseEntity.ok(this.postService.read(id));
    }

    @Override
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(this.postService.readAll());
    }

    @Override
    public ResponseEntity<?> update(Long id, PostAPIRequest dto) {
        this.postService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        this.postService.delete(id);
        return ResponseEntity.ok().build();
    }

}
