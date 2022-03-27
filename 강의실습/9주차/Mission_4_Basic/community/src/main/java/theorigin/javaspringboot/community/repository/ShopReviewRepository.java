package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.community.entity.ShopReviewEntity;

public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}
