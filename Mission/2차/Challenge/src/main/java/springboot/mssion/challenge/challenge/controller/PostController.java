package springboot.mssion.challenge.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.mssion.challenge.challenge.model.dto.request.PostAPIRequest;
import springboot.mssion.challenge.challenge.model.dto.response.PostAPIResponse;
import springboot.mssion.challenge.challenge.service.PostService;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping("")
    public String create(@RequestBody PostAPIRequest requestPost) {
        try {
            postService.create(requestPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/post/" + requestPost.getId();
    }

    @GetMapping("")
    public String readAll(Model model) {
        List<PostAPIResponse> postList = this.postService.readAll();
        model.addAttribute("postList", postList);
        return "/post/list";
    }

    @GetMapping("{id}")
    public String readOne(Model model, @PathVariable Long id) {
        PostAPIResponse post = this.postService.readOne(id);
        model.addAttribute("post", post);
        return "/post/list";
    }

}
