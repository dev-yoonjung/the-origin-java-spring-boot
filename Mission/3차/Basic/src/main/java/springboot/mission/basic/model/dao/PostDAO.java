package springboot.mission.basic.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import springboot.mission.basic.model.dto.request.PostAPIRequest;
import springboot.mission.basic.model.entity.PostEntity;
import springboot.mission.basic.repository.PostRepository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class PostDAO {

    private static final Logger logger = LoggerFactory.getLogger(PostDAO.class);
    private final PostRepository postRepository;
    private final UserDAO userDAO;
    private final BoardDAO boardDAO;

    public PostDAO(@Autowired PostRepository postRepository,
                   @Autowired UserDAO userDAO,
                   @Autowired BoardDAO boardDAO) {
        this.postRepository = postRepository;
        this.userDAO = userDAO;
        this.boardDAO = boardDAO;
    }

    public void createPost(PostAPIRequest dto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setUserEntity(this.userDAO.readUser(dto.getUserId()));
        postEntity.setBoardEntity(this.boardDAO.readBoard(dto.getBoardId()));
        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(Long id) {
        Optional<PostEntity> postEntity = this.postRepository.findById(id);
        if (postEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return postEntity.get();
    }

    public Iterator<PostEntity> readPostAll() {
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(Long id, PostAPIRequest dto) {
        Optional<PostEntity> targetEntity = this.postRepository.findById(id);
        if (targetEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        PostEntity postEntity = targetEntity.get();
        postEntity.setTitle(dto.getTitle() == null ? postEntity.getTitle() : dto.getTitle());
        postEntity.setContent(dto.getContent() == null ? postEntity.getContent() : dto.getContent());
        postEntity.setUserEntity(dto.getUserId() == null ?
                postEntity.getUserEntity() :
                this.userDAO.readUser(dto.getUserId()));
        postEntity.setBoardEntity(dto.getBoardId() == null ?
                postEntity.getBoardEntity() :
                this.boardDAO.readBoard(dto.getBoardId()));

        this.postRepository.save(postEntity);
    }

    public void deletePost(Long id) {
        this.postRepository.deleteById(id);
    }
}
