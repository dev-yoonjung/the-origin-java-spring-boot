package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.mission.basic.common.exception.CreateException;
import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.common.exception.UpdateException;
import springboot.mission.basic.model.dto.request.PostAPIRequest;
import springboot.mission.basic.model.dto.response.PostAPIResponse;
import springboot.mission.basic.service.PostService;

import java.util.List;

@RestController
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody PostAPIRequest postAPIRequest) {
        try {
            this.postService.create(postAPIRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (CreateException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostAPIResponse>> readAll() {
        return ResponseEntity.ok(this.postService.readAll());
    }

    @GetMapping("/board/{boardId}/post")
    public ResponseEntity<List<PostAPIResponse>> readInBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(this.postService.readInBoard(boardId));
    }

    @GetMapping("/post/{id}")
    public PostAPIResponse readOne(@PathVariable Long id) {
        return this.postService.readOne(id);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PostAPIRequest requestPost) {
        try {
            this.postService.update(id, requestPost);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (UpdateException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestParam String password) {
        try {
            this.postService.delete(id, password);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
