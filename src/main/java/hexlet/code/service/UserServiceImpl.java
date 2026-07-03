package hexlet.code.service;

import hexlet.code.dto.user.UserCreateDTO;
import hexlet.code.dto.user.UserDTO;
import hexlet.code.dto.user.UserUpdateDTO;
import hexlet.code.exception.ResourceDeletionException;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.UserMapper;
import hexlet.code.repository.TaskRepository;
import hexlet.code.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final TaskRepository taskRepository;

    @Override
    public List<UserDTO> index() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::map)
                .toList();
    }

    @Override
    public UserDTO show(long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return userMapper.map(user);
    }

    @Override
    public UserDTO create(UserCreateDTO dto) {

        var user = userMapper.map(dto);
        user.setPasswordDigest(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user);

        return userMapper.map(user);
    }

    @Override
    public UserDTO update(long id, UserUpdateDTO dto) {

        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        userMapper.update(dto, user);

        if (dto.getPassword() != null && dto.getPassword().isPresent()) {
            user.setPasswordDigest(passwordEncoder.encode(dto.getPassword().get()));
        }

        userRepository.save(user);

        return userMapper.map(user);
    }

    @Override
    public void delete(long id) {

        if (taskRepository.existsByAssigneeId(id)) {
            throw new ResourceDeletionException(
                    "Нельзя удалить пользователя, у него есть задача");
        }

        userRepository.deleteById(id);
    }
}
