package theorigin.javaspringboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import theorigin.javaspringboot.jpa.entity.PostEntity;
import theorigin.javaspringboot.jpa.repository.PostRepository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class PostDAO {
    private static final Logger logger = LoggerFactory.getLogger(PostDAO.class);
    private final PostRepository postRepository;

    public PostDAO(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setContent(postDTO.getContent());
        postEntity.setWriter(postDTO.getWriter());
        postEntity.setBoardEntity(null);
        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(int id) {
        Optional<PostEntity> postEntity = this.postRepository.findById((long) id);
        if (postEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return postEntity.get();
    }

    public Iterator<PostEntity> readPostAll() {
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(int id, PostDTO postDTO) {
        Optional<PostEntity> targetEntity = this.postRepository.findById((long) id);
        if (targetEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        PostEntity postEntity = targetEntity.get();
        postEntity.setTitle(postDTO.getTitle() == null ? postEntity.getTitle() : postDTO.getTitle());
        postEntity.setContent(postDTO.getContent() == null ? postEntity.getContent() : postDTO.getContent());
        postEntity.setWriter(postDTO.getWriter() == null ? postEntity.getWriter() : postDTO.getWriter());
        this.postRepository.save(postEntity);
    }

    public void deletePost(int id) {
        this.postRepository.deleteById((long) id);
    }
}
