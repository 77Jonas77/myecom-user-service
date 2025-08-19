package dev.jsojka.myecom_user_service.controller;

import dev.jsojka.myecom_user_service.dto.*;
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

    @GetMapping("/{userId}")
    public ResponseEntity<CredentialDTO> findByUserId(@PathVariable UUID userId) {
        CredentialDTO responseDTO = credentialService.findByUserId(userId);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateByUserId(@PathVariable UUID userId, @RequestBody UpdateCredentialRequestDTO requestDTO) {
        credentialService.updateByUserId(userId, requestDTO);
        return ResponseEntity.ok("User with id: " + userId + " successfully updated.");
    }
}
