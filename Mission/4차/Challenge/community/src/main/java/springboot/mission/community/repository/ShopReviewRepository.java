package springboot.mission.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.mission.community.entity.ShopReviewEntity;

@Repository
public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}
