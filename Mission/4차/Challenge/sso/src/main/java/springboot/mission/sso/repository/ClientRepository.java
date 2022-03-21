package springboot.mission.sso.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.sso.entity.OAuthClientEntity;

public interface ClientRepository extends CrudRepository<OAuthClientEntity, Long> {
    OAuthClientEntity findFirstByUid(String uid);
    OAuthClientEntity findFirstByClientId(String clientId);
}
