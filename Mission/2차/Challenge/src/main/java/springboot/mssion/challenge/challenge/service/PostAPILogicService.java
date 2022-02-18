package springboot.mssion.challenge.challenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.mssion.challenge.challenge.common.exception.CreateException;
import springboot.mssion.challenge.challenge.common.exception.DeleteException;
import springboot.mssion.challenge.challenge.common.exception.UpdateException;
import springboot.mssion.challenge.challenge.model.dto.request.PostAPIRequest;
import springboot.mssion.challenge.challenge.model.dto.response.PostAPIResponse;
import springboot.mssion.challenge.challenge.model.entity.Post;
import springboot.mssion.challenge.challenge.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostAPILogicService implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostAPILogicService.class);
    private final PostRepository postRepository;

    public PostAPILogicService(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void create(PostAPIRequest requestPost) throws CreateException {
        Post post = new Post();
        post.setTitle(requestPost.getTitle());
        post.setContent(requestPost.getContent());
        Optional<Post> savedPost = this.postRepository.save(post);
        if (savedPost.isEmpty()) throw new CreateException("create failed");
    }

    @Override
    public List<PostAPIResponse> readAll() {
        List<PostAPIResponse> responsePost = new ArrayList<>();
        this.postRepository.findAll().forEach(post -> responsePost.add(response(post)));
        return responsePost;
    }

    @Override
    public PostAPIResponse readOne(Long id) {
        Optional<Post> post = this.postRepository.findById(id);
        return post.map(this::response).orElse(null);
    }

    @Override
    public void update(Long id, PostAPIRequest requestPost) throws UpdateException {
        Post post = new Post();
        post.setId(id);
        post.setTitle(requestPost.getTitle());
        post.setContent(requestPost.getContent());
        this.postRepository.update(id, post);
    }

    @Override
    public void delete(Long id) throws DeleteException {
        this.postRepository.delete(id);
    }

    private PostAPIResponse response(Post post) {
        return new PostAPIResponse(post.getId(),
                post.getTitle(),
                post.getContent());
    }
}
