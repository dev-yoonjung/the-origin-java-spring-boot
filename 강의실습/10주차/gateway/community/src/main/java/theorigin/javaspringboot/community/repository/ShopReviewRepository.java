package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.community.entity.ShopReviewEntity;

@Repository
public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}
