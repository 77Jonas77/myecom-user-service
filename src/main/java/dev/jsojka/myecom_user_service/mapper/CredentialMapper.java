package dev.jsojka.myecom_user_service.mapper;

import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialResponseDto;
import dev.jsojka.myecom_user_service.dto.credential.CredentialDto;
import dev.jsojka.myecom_user_service.dto.credential.UpdateCredentialResponseDto;
import dev.jsojka.myecom_user_service.model.CredentialEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;

public interface CredentialMapper {
    CredentialDto entityToCredentialDTO(CredentialEntity credentialEntity);

    CredentialEntity createCredentialsRequestAndIdDtoToEntity(CreateCredentialRequestDto requestDTO, UserEntity userId);

    CreateCredentialResponseDto credentialDtoToCreateCredentialResponseDto(CredentialDto credentialDTO);

    UpdateCredentialResponseDto credentialDtoToUpdateCredentialRequestDTO(CredentialDto credentialDTO);
}
