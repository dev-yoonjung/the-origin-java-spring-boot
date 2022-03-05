package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import springboot.mission.basic.model.dao.PostDAO;
import springboot.mission.basic.model.dto.request.PostAPIRequest;
import springboot.mission.basic.model.dto.response.PostAPIResponse;
import springboot.mission.basic.model.entity.PostEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostAPILogicService implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostAPILogicService.class);
    private final PostDAO postDAO;

    public PostAPILogicService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public void create(PostAPIRequest dto) {
        this.postDAO.createPost(dto);
    }

    @Override
    public PostAPIResponse read(Long id) {
        return response(this.postDAO.readPost(id));
    }

    @Override
    public List<PostAPIResponse> readAll() {
        Iterator<PostEntity> iterator = this.postDAO.readPostAll();
        List<PostAPIResponse> postList = new ArrayList<>();

        while (iterator.hasNext()) {
            PostEntity postEntity = iterator.next();
            postList.add(response(postEntity));
        }

        return postList;
    }

    @Override
    public void update(Long id, PostAPIRequest dto) {
        this.postDAO.updatePost(id, dto);
    }

    @Override
    public void delete(Long id) {
        this.postDAO.deletePost(id);
    }

    private PostAPIResponse response(PostEntity postEntity) {
        return new PostAPIResponse(postEntity.getId(),
                                   postEntity.getTitle(),
                                   postEntity.getContent(),
                                   postEntity.getBoardEntity().getId(),
                                   postEntity.getUserEntity().getId(),
                                   postEntity.getCreatedAt(),
                                   postEntity.getUpdatedAt());
    }
}
