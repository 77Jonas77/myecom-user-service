package dev.jsojka.myecom_user_service.mapper.impl;

import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialResponseDto;
import dev.jsojka.myecom_user_service.dto.credential.CredentialDto;
import dev.jsojka.myecom_user_service.dto.credential.UpdateCredentialResponseDto;
import dev.jsojka.myecom_user_service.mapper.CredentialMapper;
import dev.jsojka.myecom_user_service.model.CredentialEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class CredentialMapperImpl implements CredentialMapper {

    @Override
    public CredentialDto entityToCredentialDTO(CredentialEntity credentialEntity) {
        return CredentialDto.builder()
                .id(credentialEntity.getId())
                .username(credentialEntity.getUsername())
                .password(credentialEntity.getPassword())
                .role(credentialEntity.getRole())
                .isEnabled(credentialEntity.getIsEnabled())
                .isAccountNonExpired(credentialEntity.getIsAccountNonExpired())
                .isAccountNonLocked(credentialEntity.getIsAccountNonLocked())
                .isCredentialsNonExpired(credentialEntity.getIsCredentialsNonExpired())
                .createdAt(credentialEntity.getCreatedAt())
                .updatedAt(credentialEntity.getUpdatedAt())
                .userId(credentialEntity.getUser().getId())
                .build();
    }

    @Override
    public CredentialEntity createCredentialsRequestAndIdDtoToEntity(CreateCredentialRequestDto requestDTO, UserEntity userEntity) {
        return CredentialEntity.builder()
                .user(userEntity)
                .username(requestDTO.username())
                .password(requestDTO.password())
                .role(requestDTO.role())
                .isEnabled(true)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .build();
    }

    @Override
    public CreateCredentialResponseDto credentialDtoToCreateCredentialResponseDto(CredentialDto credentialDTO) {
        return CreateCredentialResponseDto.builder()
                .id(credentialDTO.id())
                .username(credentialDTO.username())
                .role(credentialDTO.role())
                .isEnabled(credentialDTO.isEnabled())
                .isAccountNonExpired(credentialDTO.isAccountNonExpired())
                .isAccountNonLocked(credentialDTO.isAccountNonLocked())
                .isCredentialsNonExpired(credentialDTO.isCredentialsNonExpired())
                .createdAt(credentialDTO.createdAt())
                .updatedAt(credentialDTO.updatedAt())
                .userId(credentialDTO.userId())
                .build();
    }

    @Override
    public UpdateCredentialResponseDto credentialDtoToUpdateCredentialRequestDTO(CredentialDto credentialDTO) {
        return UpdateCredentialResponseDto.builder()
                .id(credentialDTO.id())
                .username(credentialDTO.username())
                .password(credentialDTO.password())
                .role(credentialDTO.role())
                .isEnabled(credentialDTO.isEnabled())
                .isAccountNonExpired(credentialDTO.isAccountNonExpired())
                .isAccountNonLocked(credentialDTO.isAccountNonLocked())
                .isCredentialsNonExpired(credentialDTO.isCredentialsNonExpired())
                .createdAt(credentialDTO.createdAt())
                .updatedAt(credentialDTO.updatedAt())
                .userId(credentialDTO.userId())
                .build();
    }


}
