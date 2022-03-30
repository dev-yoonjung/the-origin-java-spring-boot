package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.basic.entity.ShopReviewEntity;

public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}
