package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.model.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
