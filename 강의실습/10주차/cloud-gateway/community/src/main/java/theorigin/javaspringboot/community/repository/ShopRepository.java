package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.community.entity.ShopEntity;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}
