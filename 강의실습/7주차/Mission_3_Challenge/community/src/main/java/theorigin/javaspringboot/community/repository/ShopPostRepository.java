package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.community.entity.ShopPostEntity;

@Repository
public interface ShopPostRepository extends CrudRepository<ShopPostEntity, Long> {
}
