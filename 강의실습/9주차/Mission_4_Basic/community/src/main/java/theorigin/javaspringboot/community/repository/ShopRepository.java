package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.community.entity.ShopEntity;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}
