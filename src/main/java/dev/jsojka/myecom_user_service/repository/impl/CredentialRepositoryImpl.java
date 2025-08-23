package dev.jsojka.myecom_user_service.repository.impl;

import dev.jsojka.myecom_user_service.dto.credential.UpdateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CredentialDto;
import dev.jsojka.myecom_user_service.mapper.CredentialMapper;
import dev.jsojka.myecom_user_service.model.CredentialEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;
import dev.jsojka.myecom_user_service.repository.CredentialRepository;
import dev.jsojka.myecom_user_service.repository.jpa.CredentialRepositoryJpa;
import dev.jsojka.myecom_user_service.repository.jpa.UserRepositoryJpa;
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
    public CredentialDto save(CreateCredentialRequestDto requestDTO, UUID userId) {
        UserEntity userEntity = userRepositoryJpa.findUserById(userId).orElseThrow();
        CredentialEntity credentialEntity = credentialMapper.createCredentialsRequestAndIdDtoToEntity(requestDTO, userEntity);
        return credentialMapper.entityToCredentialDTO(credentialRepositoryJpa.save(credentialEntity));
    }

    @Override
    public CredentialDto findByUserId(UUID userId) {
        CredentialEntity entity = credentialRepositoryJpa.findByUserId(userId);
        return credentialMapper.entityToCredentialDTO(entity);
    }

    @Override
    public void updateByUserId(UpdateCredentialRequestDto requestDTO, UUID userId) {
        credentialRepositoryJpa.update(
                requestDTO.username(), requestDTO.password(),
                requestDTO.role(), requestDTO.isCredentialsNonExpired(), requestDTO.isAccountNonExpired(),
                requestDTO.isAccountNonLocked(), requestDTO.isEnabled(), userId
        );
    }

    @Override
    @Transactional
    public void deleteByUserId(UUID userId) {
        credentialRepositoryJpa.deleteByUserId(userId);
    }
}
