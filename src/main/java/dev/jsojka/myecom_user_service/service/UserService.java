package dev.jsojka.myecom_user_service.service;

import dev.jsojka.myecom_user_service.dto.user.UpdateUserDto;
import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterResponseDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterRequestDto;

import java.util.UUID;

public interface UserService {
    UserRegisterResponseDto save(UserRegisterRequestDto requestDTO);

    UserDto findById(UUID userId);

    UserDto update(UUID userId, UpdateUserDto userDTO);

    void deleteById(UUID userId);
}
