package springboot.mission.sso.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.sso.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
}