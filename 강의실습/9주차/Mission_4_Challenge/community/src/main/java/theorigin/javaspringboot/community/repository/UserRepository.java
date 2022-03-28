package theorigin.javaspringboot.community.repository;

import theorigin.javaspringboot.community.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
