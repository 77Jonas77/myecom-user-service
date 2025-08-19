package dev.jsojka.myecom_user_service.service.impl;

import dev.jsojka.myecom_user_service.dto.*;
import dev.jsojka.myecom_user_service.exception.UserNotFoundException;
import dev.jsojka.myecom_user_service.mapper.CredentialMapper;
import dev.jsojka.myecom_user_service.service.CredentialService;
import dev.jsojka.myecom_user_service.service.UserService;
import org.springframework.stereotype.Service;
import dev.jsojka.myecom_user_service.repository.CredentialRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class CredentialServiceImpl implements CredentialService {

    private final CredentialRepository credentialRepository;
    private final CredentialMapper credentialMapper;
    private final UserService userService;


    public CredentialServiceImpl(CredentialRepository credentialRepository, CredentialMapper credentialMapper, UserService userService) {
        this.credentialRepository = credentialRepository;
        this.credentialMapper = credentialMapper;
        this.userService = userService;
    }

    @Override
    public CreateCredentialResponseDTO save(CreateCredentialRequestDTO requestDTO, UUID userId) {
        CredentialDTO credentialDTO = credentialRepository.save(requestDTO, userId);
        return credentialMapper.credentialDtoToCreateCredentialResponseDto(credentialDTO);
    }

    @Override
    public CredentialDTO findByUserId(UUID userId) {
        return credentialRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void updateByUserId(UUID userId, UpdateCredentialRequestDTO requestDTO) {
        UserDTO user = userService.findById(userId);
        if (user == null) {
            throw new UserNotFoundException("User with id: " + userId + " not found!");
        }
        credentialRepository.updateByUserId(requestDTO, userId);
    }
}
