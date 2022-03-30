package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.basic.entity.AreaEntity;

public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
}
