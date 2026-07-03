package hexlet.code.service;

import hexlet.code.dto.user.UserCreateDTO;
import hexlet.code.dto.user.UserDTO;
import hexlet.code.dto.user.UserUpdateDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> index();

    UserDTO show(long id);

    UserDTO create(UserCreateDTO dto);

    UserDTO update(long id, UserUpdateDTO dto);

    void delete(long id);
}
