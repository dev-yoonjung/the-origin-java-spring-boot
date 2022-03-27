package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.community.entity.ShopPostEntity;

public interface ShopPostRepository extends CrudRepository<ShopPostEntity, Long> {
}
