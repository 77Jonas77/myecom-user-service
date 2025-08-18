package dev.jsojka.myecom_user_service.service;

import dev.jsojka.myecom_user_service.dto.UpdateUserDTO;
import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterResponseDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterRequestDTO;

import java.util.UUID;

public interface UserService {
    UserRegisterResponseDTO save(UserRegisterRequestDTO requestDTO);

    UserDTO findById(UUID userId);

    UserDTO update(UUID userId, UpdateUserDTO userDTO);

    void deleteById(UUID userId);
}
