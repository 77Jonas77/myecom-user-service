package dev.jsojka.myecom_user_service.mapper;

import dev.jsojka.myecom_user_service.dto.CreateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialResponseDTO;
import dev.jsojka.myecom_user_service.dto.CredentialDTO;
import dev.jsojka.myecom_user_service.dto.UpdateCredentialResponseDTO;
import dev.jsojka.myecom_user_service.model.CredentialEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class CredentialMapperImpl implements CredentialMapper {

    @Override
    public CredentialDTO entityToCredentialDTO(CredentialEntity credentialEntity) {
        return CredentialDTO.builder()
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
    public CredentialEntity createCredentialsRequestAndIdDtoToEntity(CreateCredentialRequestDTO requestDTO, UserEntity userEntity) {
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
    public CreateCredentialResponseDTO credentialDtoToCreateCredentialResponseDto(CredentialDTO credentialDTO) {
        return CreateCredentialResponseDTO.builder()
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
    public UpdateCredentialResponseDTO credentialDtoToUpdateCredentialRequestDTO(CredentialDTO credentialDTO) {
        return UpdateCredentialResponseDTO.builder()
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
