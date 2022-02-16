package springboot.mission.basic.repository;

import springboot.mission.basic.model.entity.Post;

import java.util.List;

public interface PostRepository extends BaseRepository<Post> {

    List<Post> findByBoardId(Long boardId);

}
