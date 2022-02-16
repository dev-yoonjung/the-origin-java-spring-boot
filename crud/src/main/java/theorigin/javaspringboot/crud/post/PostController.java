package theorigin.javaspringboot.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
//@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public void createPost(@RequestBody PostDTO postDTO) {
        logger.info(postDTO.toString());
        this.postService.createPost(postDTO);
    }

    @GetMapping("/read-all")
    public List<PostDTO> readPostAll() {
        logger.info("in read all");
        return this.postService.readPostAll();
    }

    @GetMapping("/read-one")
    public PostDTO readPostOne(@RequestParam("id") int id) {
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PostMapping("/update")
    public void updatePost(@RequestParam("id") int id, @RequestBody PostDTO postDTO) {
        logger.info("target id: " + id);
        logger.info("update content: " + postDTO);
        this.postService.updatePost(id, postDTO);
    }

    @DeleteMapping("/delete")
    public void deletePost(@RequestParam("id") int id) {
        this.postService.deletePost(id);
    }
}
