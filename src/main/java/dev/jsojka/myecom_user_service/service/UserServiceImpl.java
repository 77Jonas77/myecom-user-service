package dev.jsojka.myecom_user_service.service;

import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterResponseDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterRequestDTO;
import dev.jsojka.myecom_user_service.exception.UserAlreadyExistsException;
import dev.jsojka.myecom_user_service.mapper.UserMapper;
import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.stereotype.Service;
import dev.jsojka.myecom_user_service.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserRegisterResponseDTO registerUser(UserRegisterRequestDTO requestDTO) {
        boolean result = userRepository.existsByEmail(requestDTO.email());
        if (result) {
            throw new UserAlreadyExistsException("User with email: " + requestDTO.email() + " already exists!");
        }

        UserDTO user = userMapper.userRegisterRequestDtoAndIdToUserDTO(requestDTO, UUID.randomUUID());
        UserEntity createdUser = userRepository.save(user);
        return userMapper.userEntityToUserRegisterResponseDTO(createdUser);
    }

    @Override
    public UserDTO findUserById(UUID userId) {
        return userRepository.findUserById(userId);
    }
}
