package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.mission.basic.model.dao.UserDAO;
import springboot.mission.basic.model.dto.request.UserAPIRequest;
import springboot.mission.basic.model.dto.response.UserAPIResponse;
import springboot.mission.basic.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserAPILogicService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserAPILogicService.class);
    private final UserDAO userDAO;

    public UserAPILogicService(@Autowired UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void create(UserAPIRequest dto) {
        this.userDAO.createUser(dto);
    }

    @Override
    public UserAPIResponse read(Long id) {
        return response(this.userDAO.readUser(id));
    }

    @Override
    public List<UserAPIResponse> readAll() {
        Iterator<UserEntity> iterator = this.userDAO.readAllUser();
        List<UserAPIResponse> userList = new ArrayList<>();

        while (iterator.hasNext()) {
            UserEntity userEntity = iterator.next();
            userList.add(response(userEntity));
        }

        return userList;
    }

    @Override
    public void update(Long id, UserAPIRequest dto) {
        this.userDAO.updateUser(id, dto);
    }

    @Override
    public void delete(Long id) {
        this.userDAO.deleteUser(id);
    }

    private UserAPIResponse response(UserEntity userEntity) {
        return new UserAPIResponse(userEntity.getId(),
                                   userEntity.getName(),
                                   userEntity.getCreatedAt(),
                                   userEntity.getUpdatedAt());
    }
}
