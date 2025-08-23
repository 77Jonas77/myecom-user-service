package dev.jsojka.myecom_user_service.service;

import dev.jsojka.myecom_user_service.dto.credential.UpdateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialResponseDto;
import dev.jsojka.myecom_user_service.dto.credential.CredentialDto;

import java.util.UUID;

public interface CredentialService {
    CreateCredentialResponseDto save(CreateCredentialRequestDto requestDTO, UUID userId);

    CredentialDto findByUserId(UUID userId);

    void updateByUserId(UUID userId, UpdateCredentialRequestDto requestDTO);

    void deleteByUserId(UUID userId);
}
