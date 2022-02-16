package theorigin.javaspringboot.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryInMemory implements PostRepository{
    private static final Logger logger = LoggerFactory.getLogger(PostRepositoryInMemory.class);
    private final List<PostDTO> postList;

    public PostRepositoryInMemory() {
        this.postList = new ArrayList<>();
    }

    @Override
    public boolean save(PostDTO postDTO) {
        return this.postList.add(postDTO);
    }

    @Override
    public List<PostDTO> findAll() {
        return this.postList;
    }

    @Override
    public PostDTO findById(int id) {
        return this.postList.get(id);
    }

    @Override
    public boolean update(int id, PostDTO postDTO) {
        PostDTO targetPostDTO = this.postList.get(id);
        if (postDTO.getTitle() != null) {
            targetPostDTO.setTitle(postDTO.getTitle());
        }
        if (postDTO.getContent() != null) {
            targetPostDTO.setContent(postDTO.getContent());
        }
        this.postList.set(id, targetPostDTO);
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.postList.remove(id);
        return true;
    }
}
