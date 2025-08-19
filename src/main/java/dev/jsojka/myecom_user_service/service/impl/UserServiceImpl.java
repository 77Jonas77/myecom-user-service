package dev.jsojka.myecom_user_service.service.impl;

import dev.jsojka.myecom_user_service.dto.UpdateUserDTO;
import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterResponseDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterRequestDTO;
import dev.jsojka.myecom_user_service.exception.UserAlreadyExistsException;
import dev.jsojka.myecom_user_service.exception.UserNotFoundException;
import dev.jsojka.myecom_user_service.mapper.UserMapper;
import dev.jsojka.myecom_user_service.model.UserEntity;
import dev.jsojka.myecom_user_service.service.UserService;
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
    public UserRegisterResponseDTO save(UserRegisterRequestDTO requestDTO) {
        boolean result = userRepository.existsByEmail(requestDTO.email());
        if (result) {
            throw new UserAlreadyExistsException("User with email: " + requestDTO.email() + " already exists!");
        }

        UserDTO user = userMapper.userRegisterRequestDtoAndIdToUserDTO(requestDTO, UUID.randomUUID());
        UserEntity createdUser = userRepository.save(user);
        return userMapper.userEntityToUserRegisterResponseDTO(createdUser);
    }

    @Override
    public UserDTO findById(UUID userId) {
        UserDTO user = userRepository.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User with id: " + userId + " not found!");
        }
        return user;
    }

    @Override
    @Transactional
    public UserDTO update(UUID userId, UpdateUserDTO userDTO) {
        UserDTO user = userRepository.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User with id: " + userId + " not found!");
        }

        UserDTO userToUpdate = userMapper.mergeUserDtoWithUpdates(user, userDTO);
        return userRepository.update(userToUpdate);
    }

    @Override
    public void deleteById(UUID userId) {
        userRepository.deleteById(userId);
    }

}
