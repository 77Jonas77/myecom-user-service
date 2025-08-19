package dev.jsojka.myecom_user_service.service;

import dev.jsojka.myecom_user_service.dto.CreateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialResponseDTO;

import java.util.UUID;

public interface CredentialService {
    CreateCredentialResponseDTO save(CreateCredentialRequestDTO requestDTO, UUID userId);
}
