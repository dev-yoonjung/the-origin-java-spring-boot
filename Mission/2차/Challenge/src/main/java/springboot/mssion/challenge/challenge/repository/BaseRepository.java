package springboot.mssion.challenge.challenge.repository;

import springboot.mssion.challenge.challenge.common.exception.DeleteException;
import springboot.mssion.challenge.challenge.common.exception.UpdateException;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<Entity> {

    Optional<Entity> save(Entity entity);

    List<Entity> findAll();

    Optional<Entity> findById(Long id);

    Optional<Entity> update(Long id, Entity entity) throws UpdateException;

    void delete(Long id) throws DeleteException;

}
