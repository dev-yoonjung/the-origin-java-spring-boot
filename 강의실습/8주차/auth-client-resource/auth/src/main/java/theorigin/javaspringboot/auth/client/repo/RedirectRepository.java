package theorigin.javaspringboot.auth.client.repo;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.auth.client.entity.OAuthClientEntity;
import theorigin.javaspringboot.auth.client.entity.RedirectEntity;

import java.util.List;

public interface RedirectRepository extends CrudRepository<RedirectEntity, Long> {
    List<RedirectEntity> findAllByClient(OAuthClientEntity client);
}
