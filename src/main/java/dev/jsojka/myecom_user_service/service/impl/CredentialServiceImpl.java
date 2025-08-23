package dev.jsojka.myecom_user_service.service.impl;

import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialResponseDto;
import dev.jsojka.myecom_user_service.dto.credential.CredentialDto;
import dev.jsojka.myecom_user_service.dto.credential.UpdateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.exception.UserNotFoundException;
import dev.jsojka.myecom_user_service.mapper.CredentialMapper;
import dev.jsojka.myecom_user_service.repository.UserRepository;
import dev.jsojka.myecom_user_service.service.CredentialService;
import org.springframework.stereotype.Service;
import dev.jsojka.myecom_user_service.repository.CredentialRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CredentialServiceImpl implements CredentialService {

    private final CredentialRepository credentialRepository;
    private final CredentialMapper credentialMapper;
    private final UserRepository userRepository;

    public CredentialServiceImpl(CredentialRepository credentialRepository, CredentialMapper credentialMapper, UserRepository userRepository) {
        this.credentialRepository = credentialRepository;
        this.credentialMapper = credentialMapper;
        this.userRepository = userRepository;
    }

    @Override
    public CreateCredentialResponseDto save(CreateCredentialRequestDto requestDTO, UUID userId) {
        UserDto user = userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));

        CredentialDto credentialDTO = credentialRepository.save(requestDTO, userId);
        return credentialMapper.credentialDtoToCreateCredentialResponseDto(credentialDTO);
    }

    @Override
    public CredentialDto findByUserId(UUID userId) {
        return credentialRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void updateByUserId(UUID userId, UpdateCredentialRequestDto requestDTO) {
        UserDto user = userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));

        credentialRepository.updateByUserId(requestDTO, userId);
    }

    @Override
    public void deleteByUserId(UUID userId) {
        credentialRepository.deleteByUserId(userId);
    }
}
