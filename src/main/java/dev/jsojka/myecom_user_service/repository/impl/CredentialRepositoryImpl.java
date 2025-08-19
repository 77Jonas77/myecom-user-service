package dev.jsojka.myecom_user_service.repository.impl;

import dev.jsojka.myecom_user_service.dto.UpdateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CredentialDTO;
import dev.jsojka.myecom_user_service.mapper.CredentialMapper;
import dev.jsojka.myecom_user_service.model.CredentialEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;
import dev.jsojka.myecom_user_service.repository.CredentialRepository;
import dev.jsojka.myecom_user_service.repository.CredentialRepositoryJpa;
import dev.jsojka.myecom_user_service.repository.UserRepositoryJpa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class CredentialRepositoryImpl implements CredentialRepository {

    private final CredentialRepositoryJpa credentialRepositoryJpa;
    private final CredentialMapper credentialMapper;
    private final UserRepositoryJpa userRepositoryJpa;

    public CredentialRepositoryImpl(CredentialRepositoryJpa credentialRepositoryJpa, CredentialMapper credentialMapper, UserRepositoryJpa userRepositoryJpa) {
        this.credentialRepositoryJpa = credentialRepositoryJpa;
        this.credentialMapper = credentialMapper;
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    @Transactional
    public CredentialDTO save(CreateCredentialRequestDTO requestDTO, UUID userId) {
        UserEntity userEntity = userRepositoryJpa.findUserById(userId).orElseThrow();
        CredentialEntity credentialEntity = credentialMapper.createCredentialsRequestAndIdDtoToEntity(requestDTO, userEntity);
        return credentialMapper.entityToCredentialDTO(credentialRepositoryJpa.save(credentialEntity));
    }

    @Override
    public CredentialDTO findByUserId(UUID userId) {
        CredentialEntity entity = credentialRepositoryJpa.findByUserId(userId);
        return credentialMapper.entityToCredentialDTO(entity);
    }

    @Override
    public void updateByUserId(UpdateCredentialRequestDTO requestDTO, UUID userId) {
        credentialRepositoryJpa.update(
                        requestDTO.username(), requestDTO.password(),
                        requestDTO.role(), requestDTO.isCredentialsNonExpired(), requestDTO.isAccountNonExpired(),
                        requestDTO.isAccountNonLocked(), requestDTO.isEnabled(), userId
                );
    }
}
