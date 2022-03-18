package theorigin.javaspringboot.auth.user.repo;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.auth.user.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
}
