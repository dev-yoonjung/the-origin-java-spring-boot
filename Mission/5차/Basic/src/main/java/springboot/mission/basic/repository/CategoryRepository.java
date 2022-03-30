package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.basic.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
