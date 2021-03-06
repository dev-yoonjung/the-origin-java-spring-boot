package theorigin.javaspringboot.community.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import theorigin.javaspringboot.community.model.PostDTO;
import theorigin.javaspringboot.community.service.PostService;
import java.util.Collection;

@RestController
@RequestMapping("/board/{boardId}/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping("")
    public ResponseEntity<PostDTO> createPost(@PathVariable("boardId") Long boardId,
                                              @RequestBody PostDTO dto) {
        PostDTO result = this.postService.create(boardId, dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> readPost(@PathVariable("boardId") Long boardId,
                                            @PathVariable("postId") Long postId) {
        PostDTO postDTO = this.postService.read(boardId, postId);
        if (postDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("")
    public ResponseEntity<Collection<PostDTO>> readPostAll(@PathVariable("boardId") Long boardId) {
        Collection<PostDTO> postList = this.postService.readAll(boardId);
        if (postList == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(postList);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable("boardId") Long boardId,
                                        @PathVariable("postId") Long postId,
                                        @RequestBody PostDTO dto) {
        if (!postService.update(boardId, postId, dto))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("boardId") Long boardId,
                                        @PathVariable("postId") Long postId,
                                        @RequestParam("password") String password) {
        if (!postService.delete(boardId, postId, password))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
