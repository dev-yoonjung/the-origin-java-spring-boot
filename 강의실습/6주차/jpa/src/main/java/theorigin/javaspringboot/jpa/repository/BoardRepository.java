package theorigin.javaspringboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.jpa.entity.BoardEntity;

@Repository
public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
