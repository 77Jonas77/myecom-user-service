package dev.jsojka.myecom_user_service.service.impl;

import dev.jsojka.myecom_user_service.dto.user.UpdateUserDto;
import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterResponseDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterRequestDto;
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
    public UserRegisterResponseDto save(UserRegisterRequestDto requestDTO) {
        boolean result = userRepository.existsByEmail(requestDTO.email());
        if (result) {
            throw new UserAlreadyExistsException("User with email: " + requestDTO.email() + " already exists!");
        }

        UserDto user = userMapper.userRegisterRequestDtoAndIdToUserDTO(requestDTO, UUID.randomUUID());
        UserEntity createdUser = userRepository.save(user);
        return userMapper.userEntityToUserRegisterResponseDTO(createdUser);
    }

    @Override
    public UserDto findById(UUID userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));
    }

    @Override
    @Transactional
    public UserDto update(UUID userId, UpdateUserDto userDTO) {
        UserDto user = userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));


        UserDto userToUpdate = userMapper.mergeUserDtoWithUpdates(user, userDTO);
        return userRepository.update(userToUpdate);
    }

    @Override
    public void deleteById(UUID userId) {
        userRepository.deleteById(userId);
    }

}
