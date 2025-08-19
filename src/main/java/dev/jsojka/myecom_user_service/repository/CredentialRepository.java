package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.dto.UpdateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CredentialDTO;

import java.util.UUID;

public interface CredentialRepository {
    CredentialDTO save(CreateCredentialRequestDTO requestDTO, UUID userId);

    CredentialDTO findByUserId(UUID userId);

    void updateByUserId(UpdateCredentialRequestDTO requestDTO, UUID userId);
}
