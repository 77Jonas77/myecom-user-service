package dev.jsojka.myecom_user_service.service;

import dev.jsojka.myecom_user_service.dto.UserRegisterResponseDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterRequestDTO;

public interface UserService {
    UserRegisterResponseDTO registerUser(UserRegisterRequestDTO requestDTO);
}
