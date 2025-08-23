package dev.jsojka.myecom_user_service.controller;

import dev.jsojka.myecom_user_service.dto.address.AddressDto;
import dev.jsojka.myecom_user_service.dto.address.CreateAddressRequestDto;
import dev.jsojka.myecom_user_service.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users/{userId}/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDto> save(
            @PathVariable UUID userId,
            @RequestBody @Valid CreateAddressRequestDto requestDTO
    ) {
        AddressDto responseDTO = addressService.save(userId, requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> findByUserId(@PathVariable UUID userId) {
        List<AddressDto> responseDTO = addressService.findByUserId(userId);
        return ResponseEntity.ok(responseDTO);
    }
}
