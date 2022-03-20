package springboot.mission.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.community.entity.ShopEntity;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}
