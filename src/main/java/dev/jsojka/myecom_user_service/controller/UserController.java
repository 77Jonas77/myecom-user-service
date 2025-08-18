package dev.jsojka.myecom_user_service.controller;

import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterRequestDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.jsojka.myecom_user_service.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDTO> save(
            @Valid @RequestBody UserRegisterRequestDTO request) {
        UserRegisterResponseDTO response = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findById(@PathVariable UUID userId) {
        UserDTO response = userService.findById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
