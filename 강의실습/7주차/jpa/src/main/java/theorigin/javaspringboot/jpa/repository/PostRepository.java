package theorigin.javaspringboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.jpa.entity.PostEntity;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer); // where writer = ?
//    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity); // where writer = ? and board_entity_id = ?
    List<PostEntity> findAllByWriterContaining(String writer);
}
