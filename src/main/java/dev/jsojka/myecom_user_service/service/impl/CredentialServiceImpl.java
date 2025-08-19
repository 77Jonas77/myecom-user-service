package dev.jsojka.myecom_user_service.service.impl;

import dev.jsojka.myecom_user_service.dto.CreateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialResponseDTO;
import dev.jsojka.myecom_user_service.dto.CredentialDTO;
import dev.jsojka.myecom_user_service.mapper.CredentialMapper;
import dev.jsojka.myecom_user_service.service.CredentialService;
import org.springframework.stereotype.Service;
import dev.jsojka.myecom_user_service.repository.CredentialRepository;

import java.util.UUID;

@Service
public class CredentialServiceImpl implements CredentialService {

    private final CredentialRepository credentialRepository;
    private final CredentialMapper credentialMapper;

    public CredentialServiceImpl(CredentialRepository credentialRepository, CredentialMapper credentialMapper) {
        this.credentialRepository = credentialRepository;
        this.credentialMapper = credentialMapper;
    }

    @Override
    public CreateCredentialResponseDTO save(CreateCredentialRequestDTO requestDTO, UUID userId) {
        CredentialDTO credentialDTO = credentialRepository.save(requestDTO, userId);
        return credentialMapper.credentialDtoToCreateCredentialResponseDto(credentialDTO);
    }
}
