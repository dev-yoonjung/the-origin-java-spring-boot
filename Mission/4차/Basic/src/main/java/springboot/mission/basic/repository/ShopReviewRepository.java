package springboot.mission.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.entity.ShopReviewEntity;

@Repository
public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}
