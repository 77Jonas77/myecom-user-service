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

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<AddressDto> findByUserId(UUID userId) {
        List<AddressEntity> addressEntities = addressRepositoryJpa.findByUserId(userId);

        List<AddressDto> addressList = new ArrayList<>();
        for (AddressEntity addressEntity : addressEntities) {
            addressList.add(addressMapper.addressEntityToAddressDTO(addressEntity));
        }
        return addressList;
    }

    @Override
    public void deleteByAddressIdAndUserId(Integer addressId, UUID userId) {
        addressRepositoryJpa.deleteByAddressIdAndUserId(addressId, userId);
    }

}
