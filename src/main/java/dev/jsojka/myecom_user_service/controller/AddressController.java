package dev.jsojka.myecom_user_service.controller;

import dev.jsojka.myecom_user_service.dto.address.AddressDto;
import dev.jsojka.myecom_user_service.dto.address.CreateAddressRequestDto;
import dev.jsojka.myecom_user_service.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<AddressDto> save(@PathVariable UUID userId, @RequestBody @Valid CreateAddressRequestDto requestDTO) {
        AddressDto responseDTO = addressService.save(userId, requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
