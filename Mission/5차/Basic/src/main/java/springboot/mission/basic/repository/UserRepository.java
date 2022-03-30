package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.basic.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
