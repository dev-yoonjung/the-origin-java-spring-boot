package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.community.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
