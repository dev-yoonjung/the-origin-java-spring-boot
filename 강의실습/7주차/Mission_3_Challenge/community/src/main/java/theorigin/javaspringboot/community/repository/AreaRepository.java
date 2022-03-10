package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.community.entity.AreaEntity;

@Repository
public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
}
