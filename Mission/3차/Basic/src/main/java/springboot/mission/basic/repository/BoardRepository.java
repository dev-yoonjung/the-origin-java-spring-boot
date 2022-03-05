package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.model.entity.BoardEntity;

@Repository
public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
