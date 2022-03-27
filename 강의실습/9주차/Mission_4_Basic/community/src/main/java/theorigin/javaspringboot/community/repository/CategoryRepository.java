package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.community.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
