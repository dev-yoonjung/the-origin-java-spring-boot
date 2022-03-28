package theorigin.javaspringboot.community.repository;

import theorigin.javaspringboot.community.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}
