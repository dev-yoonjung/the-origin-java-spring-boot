package theorigin.javaspringboot.community.service;

import theorigin.javaspringboot.community.model.UserDTO;

import java.util.Collection;

public interface UserService {

    UserDTO create(UserDTO dto);

    UserDTO read(Long id);

    Collection<UserDTO> readAll();

    boolean update(Long id, UserDTO dto);

    boolean delete(Long id);
    
}
