package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.entity.ShopPostEntity;

@Repository
public interface ShopPostRepository extends CrudRepository<ShopPostEntity, Long> {
}
