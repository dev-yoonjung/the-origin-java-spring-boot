package springboot.mission.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.community.entity.AreaEntity;

@Repository
public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
}
