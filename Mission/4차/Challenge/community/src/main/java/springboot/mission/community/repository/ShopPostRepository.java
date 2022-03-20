package springboot.mission.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.community.entity.ShopPostEntity;

@Repository
public interface ShopPostRepository extends CrudRepository<ShopPostEntity, Long> {
}
