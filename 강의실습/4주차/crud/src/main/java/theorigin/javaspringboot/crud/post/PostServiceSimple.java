package theorigin.javaspringboot.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceSimple implements PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final PostRepository postRepository;

    public PostServiceSimple(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDTO postDTO) {
        // TODO
        if (!this.postRepository.save(postDTO)) {
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<PostDTO> readPostAll() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDTO readPost(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDTO postDTO) {
        this.postRepository.update(id, postDTO);
    }

    @Override
    public void deletePost(int id) {
        this.postRepository.delete(id);
    }
}
