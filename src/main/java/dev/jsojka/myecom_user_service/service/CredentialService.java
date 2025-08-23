package dev.jsojka.myecom_user_service.service;

import dev.jsojka.myecom_user_service.dto.UpdateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialResponseDTO;
import dev.jsojka.myecom_user_service.dto.CredentialDTO;
import dev.jsojka.myecom_user_service.dto.UpdateCredentialResponseDTO;

import java.util.UUID;

public interface CredentialService {
    CreateCredentialResponseDTO save(CreateCredentialRequestDTO requestDTO, UUID userId);

    CredentialDTO findByUserId(UUID userId);

    void updateByUserId(UUID userId, UpdateCredentialRequestDTO requestDTO);

    void deleteByUserId(UUID userId);
}
