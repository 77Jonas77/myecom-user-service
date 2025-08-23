package dev.jsojka.myecom_user_service.controller;

import dev.jsojka.myecom_user_service.dto.ApiResponse;
import dev.jsojka.myecom_user_service.dto.user.UpdateUserDto;
import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterRequestDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterResponseDto;
import dev.jsojka.myecom_user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> save(@Valid @RequestBody UserRegisterRequestDto request) {
        UserRegisterResponseDto response = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable UUID userId) {
        UserDto response = userService.findById(userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateById(
            @PathVariable UUID userId,
            @RequestBody @Valid UpdateUserDto userDTO
    ) {
        UserDto response = userService.update(userId, userDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable UUID userId) {
        userService.deleteById(userId);
        return ResponseEntity.ok(new ApiResponse("User with id: " + userId + " deleted successfully."));
    }

}
