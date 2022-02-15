package theorigin.javaspringboot.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
//@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final List<PostDTO> postList;

    public PostController() {
        postList = new ArrayList<>();
    }

    @PostMapping("/create")
    public void createPost(@RequestBody PostDTO postDTO) {
        logger.info(postDTO.toString());
        this.postList.add(postDTO);
    }

    @GetMapping("/read-all")
    public List<PostDTO> readPostAll() {
        logger.info("in read all");
        return this.postList;
    }

    @GetMapping("/read-one")
    public PostDTO readPostOne(@RequestParam("id") int id) {
        logger.info("in read one");
        return this.postList.get(id);
    }

    @PostMapping("/update")
    public void updatePost(@RequestParam("id") int id, @RequestBody PostDTO postDTO) {
        PostDTO targetPostDTO = this.postList.get(id);
        if (postDTO.getTitle() != null) {
            targetPostDTO.setTitle(postDTO.getTitle());
        }
        if (postDTO.getContent() != null) {
            targetPostDTO.setContent(postDTO.getContent());
        }
        this.postList.set(id, targetPostDTO);
    }

    @DeleteMapping("/delete")
    public void deletePost(@RequestParam("id") int id) {
        this.postList.remove(id);
    }
}
