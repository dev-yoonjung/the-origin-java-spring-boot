package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.entity.ShopEntity;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}
