package springboot.mission.basic.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.common.exception.UpdateException;
import springboot.mission.basic.model.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Post repository. This class implements PostRepository interface.
 * post is saved in memory(ArrayList).
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 17. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
@Repository
public class PostRepositoryInMemory implements PostRepository {

    private static final Logger logger = LoggerFactory.getLogger(BoardRepositoryInMemory.class);
    private final List<Post> postList;

    public PostRepositoryInMemory() {
        this.postList = new ArrayList<>();
    }

    /**
     * Get post save.
     *
     * @param post
     * @return post
     */
    @Override
    public Optional<Post> save(Post post) {
        if (this.postList.size() == 0) post.setId(1L);
        else post.setId((this.postList.get(this.postList.size()-1).getId()) + 1); // Auto increment
        this.postList.add(post);
        logger.info("insert into postList");

        return Optional.of(post);
    }

    /**
     * Get post list.
     *
     * @return posts
     */
    @Override
    public List<Post> findAll() {
        logger.info("select * from postList");
        return this.postList;
    }

    /**
     * Get post by board id.
     *
     * @param boardId board id
     * @return posts
     */
    @Override
    public List<Post> findByBoardId(Long boardId) {
        List<Post> findPosts = new ArrayList<>();
        for (Post post : this.postList) {
            if (Objects.equals(post.getBoard().getId(), boardId)) findPosts.add(post);
        }
        logger.info("select * from postList where board id = " + boardId);
        return findPosts;
    }

    /**
     * Get post by post id.
     *
     * @param id post id
     * @return post
     */
    @Override
    public Optional<Post> findById(Long id) {
        int index = findIndexById(id);
        logger.info("select * from postList where id = " + id);
        return index != -1 ? Optional.ofNullable(this.postList.get(index)) : Optional.empty();
    }

    /**
     * update post.
     *
     * @param id post id
     */
    @Override
    public Optional<Post> update(Long id, Post post) throws UpdateException {
        int index = findIndexById(id);
        if (index != -1) {
            this.postList.set(index, post);
            logger.info("update postList set " + post.toString());
            return Optional.of(post);
        } else {
            throw new UpdateException("update failed because there was no post with this id.");
        }
    }

    /**
     * remove post by post id.
     *
     * @param id post id
     */
    @Override
    public void delete(Long id) throws DeleteException {
        int index = findIndexById(id);
        if (index != -1) {
            this.postList.remove(index);
            logger.info("delete from postList where id = " + id);
        } else {
            throw new DeleteException("delete failed because there was no post with this id.");
        }
    }

    /**
     * Get index by post id.
     *
     * @param id post id
     * @return index
     */
    private int findIndexById(Long id) {
        int index = 0;
        boolean isExist = false;
        for (Post post : this.postList) {
            if (Objects.equals(post.getId(), id)) {
                isExist = true;
                break;
            }
            index++;
        }

        return isExist ? index : -1;
    }
}
