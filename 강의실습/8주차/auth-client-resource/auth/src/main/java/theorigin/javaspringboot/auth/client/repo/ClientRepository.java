package theorigin.javaspringboot.auth.client.repo;

import org.springframework.data.repository.CrudRepository;
import theorigin.javaspringboot.auth.client.entity.OAuthClientEntity;

public interface ClientRepository extends CrudRepository<OAuthClientEntity, Long> {
    OAuthClientEntity findFirstByUid(String uid);
    OAuthClientEntity findFirstByClientId(String clientId);
}
