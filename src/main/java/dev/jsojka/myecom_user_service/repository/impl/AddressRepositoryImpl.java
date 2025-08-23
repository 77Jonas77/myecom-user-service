package dev.jsojka.myecom_user_service.repository.impl;

import dev.jsojka.myecom_user_service.dto.address.AddressDto;
import dev.jsojka.myecom_user_service.dto.address.CreateAddressRequestDto;
import dev.jsojka.myecom_user_service.mapper.AddressMapper;
import dev.jsojka.myecom_user_service.model.AddressEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;
import dev.jsojka.myecom_user_service.repository.AddressRepository;
import dev.jsojka.myecom_user_service.repository.jpa.AddressRepositoryJpa;
import dev.jsojka.myecom_user_service.repository.jpa.UserRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private final AddressRepositoryJpa addressRepositoryJpa;
    private final UserRepositoryJpa userRepositoryJpa;
    private final AddressMapper addressMapper;

    public AddressRepositoryImpl(AddressRepositoryJpa addressRepositoryJpa, UserRepositoryJpa userRepositoryJpa, AddressMapper addressMapper) {
        this.addressRepositoryJpa = addressRepositoryJpa;
        this.userRepositoryJpa = userRepositoryJpa;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDto save(UUID userId, CreateAddressRequestDto requestDTO) {
        Optional<UserEntity> userEntity = userRepositoryJpa.findUserById(userId);
        AddressEntity addressEntity = addressMapper.createAddressRequestDtoAndUserToAddressEntity(requestDTO, userEntity);
        AddressEntity address = addressRepositoryJpa.save(addressEntity);
        return addressMapper.addressEntityToAddressDTO(address);
    }
}
