package dev.jsojka.myecom_user_service.controller;

import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialResponseDto;
import dev.jsojka.myecom_user_service.dto.credential.CredentialDto;
import dev.jsojka.myecom_user_service.dto.credential.UpdateCredentialRequestDto;
import jakarta.validation.Valid;
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
    public ResponseEntity<CreateCredentialResponseDto> save(@PathVariable UUID userId, @RequestBody @Valid CreateCredentialRequestDto requestDTO) {
        CreateCredentialResponseDto responseDTO = credentialService.save(requestDTO, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CredentialDto> findByUserId(@PathVariable UUID userId) {
        CredentialDto responseDTO = credentialService.findByUserId(userId);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateByUserId(@PathVariable UUID userId, @RequestBody UpdateCredentialRequestDto requestDTO) {
        credentialService.updateByUserId(userId, requestDTO);
        return ResponseEntity.ok().body("Credential for user + " + userId + " updated successfully.");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteByUserId(@PathVariable UUID userId) {
        credentialService.deleteByUserId(userId);
        return ResponseEntity.ok().body("Credential for user + " + userId + " deleted successfully.");
    }
}
