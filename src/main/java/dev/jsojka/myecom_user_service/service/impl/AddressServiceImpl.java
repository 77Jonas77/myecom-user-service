package dev.jsojka.myecom_user_service.service.impl;

import dev.jsojka.myecom_user_service.dto.address.AddressDto;
import dev.jsojka.myecom_user_service.dto.address.CreateAddressRequestDto;
import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.exception.UserNotFoundException;
import dev.jsojka.myecom_user_service.mapper.AddressMapper;
import dev.jsojka.myecom_user_service.repository.AddressRepository;
import dev.jsojka.myecom_user_service.repository.UserRepository;
import dev.jsojka.myecom_user_service.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDto save(UUID userId, CreateAddressRequestDto requestDTO) {
        // I'm not sure in it is correct to query user
        UserDto user = userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));

        return addressRepository.save(userId, requestDTO);
    }

    @Override
    @Transactional
    public List<AddressDto> findByUserId(UUID userId) {
        userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));

        return addressRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteByAddressIdAndUserId(Integer addressId, UUID userId) {
        addressRepository.deleteByAddressIdAndUserId(addressId, userId);
    }

}
