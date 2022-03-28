package theorigin.javaspringboot.community.repository;

import theorigin.javaspringboot.community.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
