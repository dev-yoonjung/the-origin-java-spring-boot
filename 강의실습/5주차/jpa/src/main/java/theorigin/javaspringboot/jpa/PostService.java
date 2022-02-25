package theorigin.javaspringboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import theorigin.javaspringboot.jpa.entity.PostEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDAO postDAO;

    public PostService(@Autowired PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public void createPost(PostDTO postDTO) {
        this.postDAO.createPost(postDTO);
    }

    public PostDTO readPost(int id) {
        PostEntity postEntity = this.postDAO.readPost(id);
        return new PostDTO(
                Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
        );
    }

    public List<PostDTO> readPostAll() {
        Iterator<PostEntity> iterator = this.postDAO.readPostAll();
        List<PostDTO> postDTOList = new ArrayList<>();

        while (iterator.hasNext()) {
            PostEntity postEntity = iterator.next();
            postDTOList.add(new PostDTO(
                    Math.toIntExact(postEntity.getId()),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter(),
                    postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
            ));
        }

        return postDTOList;
    }

    public void updatePost(int id, PostDTO postDTO) {
        this.postDAO.updatePost(id, postDTO);
    }

    public void deletePost(int id) {
        this.postDAO.deletePost(id);
    }
}
