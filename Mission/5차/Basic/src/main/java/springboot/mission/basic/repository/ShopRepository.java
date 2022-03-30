package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.basic.entity.ShopEntity;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}
