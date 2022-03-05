package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.model.entity.PostEntity;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
