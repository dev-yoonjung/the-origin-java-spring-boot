package springboot.mission.basic.repository;

import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.common.exception.UpdateException;

import java.util.List;
import java.util.Optional;

/**
 * Base repository interface. This interface is based on CRUD.
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 17. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
public interface BaseRepository<Entity> {

    Optional<Entity> save(Entity entity);

    List<Entity> findAll();

    Optional<Entity> findById(Long id);

    Optional<Entity> update(Long id, Entity entity) throws UpdateException;

    void delete(Long id) throws DeleteException;

}
