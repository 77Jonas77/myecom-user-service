package dev.jsojka.myecom_user_service.mapper;

import dev.jsojka.myecom_user_service.dto.CreateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialResponseDTO;
import dev.jsojka.myecom_user_service.dto.CredentialDTO;
import dev.jsojka.myecom_user_service.dto.UpdateCredentialResponseDTO;
import dev.jsojka.myecom_user_service.model.CredentialEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;

public interface CredentialMapper {
    CredentialDTO entityToCredentialDTO(CredentialEntity credentialEntity);

    CredentialEntity createCredentialsRequestAndIdDtoToEntity(CreateCredentialRequestDTO requestDTO, UserEntity userId);

    CreateCredentialResponseDTO credentialDtoToCreateCredentialResponseDto(CredentialDTO credentialDTO);

    UpdateCredentialResponseDTO credentialDtoToUpdateCredentialRequestDTO(CredentialDTO credentialDTO);
}
