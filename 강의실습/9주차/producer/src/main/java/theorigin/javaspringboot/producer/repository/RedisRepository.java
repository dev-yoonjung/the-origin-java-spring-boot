package theorigin.javaspringboot.producer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.producer.model.JobProcess;

@Repository
public interface RedisRepository extends CrudRepository<JobProcess, String> {
}
