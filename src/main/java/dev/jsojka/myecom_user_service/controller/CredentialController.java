package dev.jsojka.myecom_user_service.controller;

import dev.jsojka.myecom_user_service.dto.ApiResponse;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialRequestDto;
import dev.jsojka.myecom_user_service.dto.credential.CreateCredentialResponseDto;
import dev.jsojka.myecom_user_service.dto.credential.CredentialDto;
import dev.jsojka.myecom_user_service.dto.credential.UpdateCredentialRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.jsojka.myecom_user_service.service.CredentialService;

import java.util.UUID;

@RestController
@RequestMapping("/v1/users/{userId}/credentials")
@RequiredArgsConstructor
public class CredentialController {

    private final CredentialService credentialService;

    @PostMapping
    public ResponseEntity<CreateCredentialResponseDto> save(
            @PathVariable UUID userId,
            @RequestBody @Valid CreateCredentialRequestDto requestDTO
    ) {
        CreateCredentialResponseDto responseDTO = credentialService.save(requestDTO, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<CredentialDto> findByUserId(@PathVariable UUID userId) {
        CredentialDto responseDTO = credentialService.findByUserId(userId);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateByUserId(
            @PathVariable UUID userId,
            @RequestBody @Valid UpdateCredentialRequestDto requestDTO
    ) {
        credentialService.updateByUserId(userId, requestDTO);
        return ResponseEntity.ok(new ApiResponse("Credential for user " + userId + " updated successfully."));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteByUserId(@PathVariable UUID userId) {
        credentialService.deleteByUserId(userId);
        return ResponseEntity.ok(new ApiResponse("Credential for user " + userId + " deleted successfully."));
    }
}
