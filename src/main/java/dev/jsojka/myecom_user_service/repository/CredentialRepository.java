package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.dto.credential.UpdateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CredentialDto;

import java.util.UUID;

public interface CredentialRepository {
    CredentialDto save(CreateCredentialRequestDto requestDTO, UUID userId);

    CredentialDto findByUserId(UUID userId);

    void updateByUserId(UpdateCredentialRequestDto requestDTO, UUID userId);

    void deleteByUserId(UUID userId);
}
