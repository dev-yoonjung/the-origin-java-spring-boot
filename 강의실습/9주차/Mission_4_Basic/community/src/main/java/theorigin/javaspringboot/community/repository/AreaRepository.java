package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.community.entity.AreaEntity;

public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
}
