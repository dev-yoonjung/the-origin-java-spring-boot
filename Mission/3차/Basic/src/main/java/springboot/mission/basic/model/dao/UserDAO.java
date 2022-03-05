package springboot.mission.basic.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import springboot.mission.basic.model.dto.request.UserAPIRequest;
import springboot.mission.basic.model.entity.UserEntity;
import springboot.mission.basic.repository.UserRepository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
    private final UserRepository userRepository;

    public UserDAO(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserAPIRequest dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(dto.getName());
        this.userRepository.save(userEntity);
    }

    public UserEntity readUser(Long id) {
        Optional<UserEntity> userEntity = this.userRepository.findById(id);
        if (userEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        return userEntity.get();
    }

    public Iterator<UserEntity> readAllUser() {
        return this.userRepository.findAll().iterator();
    }

    public void updateUser(Long id, UserAPIRequest dto) {
        Optional<UserEntity> targetEntity = this.userRepository.findById(id);
        if (targetEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        UserEntity userEntity = targetEntity.get();
        userEntity.setName(dto.getName() == null ? userEntity.getName() : dto.getName());
        this.userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
