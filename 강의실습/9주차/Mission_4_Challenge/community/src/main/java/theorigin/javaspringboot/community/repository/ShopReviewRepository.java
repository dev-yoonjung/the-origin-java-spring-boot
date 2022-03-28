package theorigin.javaspringboot.community.repository;

import theorigin.javaspringboot.community.entity.ShopReviewEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}
