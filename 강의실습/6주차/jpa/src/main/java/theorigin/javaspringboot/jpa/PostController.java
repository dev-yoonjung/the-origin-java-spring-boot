package theorigin.javaspringboot.jpa;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService, @Autowired Gson gson) {
        this.postService = postService;
        logger.info(gson.toString());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDTO postDTO) {
        this.postService.createPost(postDTO);
    }

    @GetMapping("/{id}")
    public PostDTO readPost(@PathVariable("id") int id) {
        return this.postService.readPost(id);
    }

    @GetMapping("")
    public List<PostDTO> readPostAll() {
        return this.postService.readPostAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDTO postDTO) {
        this.postService.updatePost(id, postDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
        logger.info("deletePost, id: {}", id);
        this.postService.deletePost(id);
    }

    @GetMapping("test-log")
    public void testLog() {
        logger.trace("TRACE Log Message");
        logger.debug("DEBUG Log Message");
        logger.info("INFO Log Message");
        logger.warn("WARN Log Message");
        logger.error("ERROR Log Message");
    }

}
