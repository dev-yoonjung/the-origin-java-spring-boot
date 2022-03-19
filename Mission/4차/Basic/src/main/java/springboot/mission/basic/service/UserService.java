package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springboot.mission.basic.controller.dto.UserDTO;
import springboot.mission.basic.entity.AreaEntity;
import springboot.mission.basic.entity.UserEntity;
import springboot.mission.basic.repository.AreaRepository;
import springboot.mission.basic.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final AreaRepository areaRepository;

    public UserService(
            @Autowired UserRepository userRepository,
            @Autowired AreaRepository areaRepository
    ) {
        this.userRepository = userRepository;
        this.areaRepository = areaRepository;

        AreaEntity seochoArea = new AreaEntity();
        seochoArea.setRegionMajor("서울시");
        seochoArea.setRegionMinor("서초구");
        seochoArea.setRegionPatch("서초동");
        seochoArea.setLongitude(37.4877);
        seochoArea.setLatitude(127.0174);
        this.areaRepository.save(seochoArea);

        AreaEntity yeoksamArea = new AreaEntity();
        yeoksamArea.setRegionMajor("서울시");
        yeoksamArea.setRegionMinor("강남구");
        yeoksamArea.setRegionPatch("역삼동");
        yeoksamArea.setLongitude(37.4999);
        yeoksamArea.setLatitude(127.0565);
        this.areaRepository.save(yeoksamArea);

        AreaEntity samseongArea = new AreaEntity();
        samseongArea.setRegionMajor("서울시");
        samseongArea.setRegionMinor("강남구");
        samseongArea.setRegionPatch("삼성동");
        samseongArea.setLongitude(37.5140);
        samseongArea.setLatitude(127.0565);
        this.areaRepository.save(samseongArea);
    }

    public void createUser(UserDTO userDto){
        Optional<AreaEntity> areaEntityOptional = this.areaRepository.findById(userDto.getAreaId());
        if (areaEntityOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        AreaEntity residence = areaEntityOptional.get();

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setShopOwner(userDto.getIsShopOwner());
        userEntity.setResidence(residence);
        this.userRepository.save(userEntity);
    }

    public UserDTO readUser(Long id) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(id);
        if (userEntityOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new UserDTO(userEntityOptional.get());
    }

    public List<UserDTO> readUserAll(){
        List<UserDTO> userDtoList = new ArrayList<>();
        this.userRepository.findAll().forEach(userEntity ->
                userDtoList.add(new UserDTO(userEntity)));
        return userDtoList;
    }

    public void updateUser(Long id, UserDTO dto){
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(id);
        if (userEntityOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        UserEntity userEntity = userEntityOptional.get();
        userEntity.setPassword(
                dto.getPassword() == null ? userEntity.getPassword() : dto.getPassword()
        );
        userEntity.setShopOwner(
                dto.getIsShopOwner() == null ? userEntity.getShopOwner() : dto.getIsShopOwner()
        );

        Optional<AreaEntity> newArea = this.areaRepository.findById(
                dto.getId() == null ? userEntity.getResidence().getId() : dto.getAreaId());

        newArea.ifPresent(userEntity::setResidence);
        userRepository.save(userEntity);
    }

    public void deleteUser(Long id){
        if (!this.userRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        this.userRepository.deleteById(id);
    }

}
