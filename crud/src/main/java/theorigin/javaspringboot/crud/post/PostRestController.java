package theorigin.javaspringboot.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final List<PostDTO> postList;

    public PostRestController() {
        this.postList = new ArrayList<>();
    }

    // http://localhost:8080/post
    // POST /post

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDTO postDTO) {
        logger.info(postDTO.toString());
        this.postList.add(postDTO);
    }

    // http://localhost:8080/post
    // GET /post

    @GetMapping()
    public List<PostDTO> readPostAll() {
        logger.info("in read post all");
        return this.postList;
    }

    // http://localhost:8080/post/0
    // GET /post/0

    @GetMapping("/{id}")
    public PostDTO readPostOne(@PathVariable("id") int id) {
        logger.info("in read post");
        return this.postList.get(id);
    }

    // http://localhost:8080/post/0
    // PUT /post/0

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDTO postDTO) {
        PostDTO targetPostDTO = this.postList.get(id);
        if (postDTO.getTitle() != null) {
            targetPostDTO.setTitle(postDTO.getTitle());
        }
        if (postDTO.getContent() != null) {
            targetPostDTO.setContent(postDTO.getContent());
        }
        this.postList.set(id, targetPostDTO);
    }

    // http://localhost:8080/post/0
    // DELETE /post/0

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
        this.postList.remove(id);
    }
}
