package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.basic.entity.ShopPostEntity;

public interface ShopPostRepository extends CrudRepository<ShopPostEntity, Long> {
}
