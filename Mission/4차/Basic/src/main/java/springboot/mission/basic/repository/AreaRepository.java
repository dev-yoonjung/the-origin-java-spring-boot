package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.entity.AreaEntity;

@Repository
public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
}
