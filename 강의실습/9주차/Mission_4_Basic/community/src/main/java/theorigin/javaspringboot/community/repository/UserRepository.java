package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.community.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
