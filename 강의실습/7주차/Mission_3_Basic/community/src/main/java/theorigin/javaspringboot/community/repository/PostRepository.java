package theorigin.javaspringboot.community.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.community.jpa.entity.PostEntity;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
