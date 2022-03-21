package springboot.mission.sso.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.mission.sso.entity.OAuthClientEntity;
import springboot.mission.sso.entity.RedirectEntity;

import java.util.List;

public interface RedirectRepository extends CrudRepository<RedirectEntity, Long> {
    List<RedirectEntity> findAllByClient(OAuthClientEntity client);
}
