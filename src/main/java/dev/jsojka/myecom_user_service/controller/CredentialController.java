package dev.jsojka.myecom_user_service.controller;

import dev.jsojka.myecom_user_service.dto.CreateCredentialRequestDTO;
import dev.jsojka.myecom_user_service.dto.CreateCredentialResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.jsojka.myecom_user_service.service.CredentialService;

import java.util.UUID;

@RestController
@RequestMapping("/v1/credentials")
public class CredentialController {

    private final CredentialService credentialService;

    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<CreateCredentialResponseDTO> save(@PathVariable UUID userId, @RequestBody CreateCredentialRequestDTO requestDTO) {
        CreateCredentialResponseDTO responseDTO = credentialService.save(requestDTO, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
