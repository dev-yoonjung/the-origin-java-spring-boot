package theorigin.javaspringboot.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.consumer.model.JobProcess;

@Repository
public interface RedisRepository extends CrudRepository<JobProcess, String> {
}
