package dev.jsojka.myecom_user_service.mapper.impl;

import dev.jsojka.myecom_user_service.dto.user.UpdateUserDto;
import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterRequestDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterResponseDto;
import dev.jsojka.myecom_user_service.mapper.UserMapper;
import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

//@Mapper(componentModel = "spring")
@Component
public class UserMapperImpl implements UserMapper {
    public UserDto userRegisterRequestDtoAndIdToUserDTO(UserRegisterRequestDto requestDTO, UUID userId) {
        return UserDto.builder()
                .id(userId)
                .firstName(requestDTO.firstName())
                .lastName(requestDTO.lastName())
                .imageUrl(requestDTO.imageUrl())
                .email(requestDTO.email())
                .phone(requestDTO.phone())
                .build();
    }

    public UserEntity userDtoToEntity(UserDto userDTO) {
        return UserEntity.builder()
                .id(userDTO.id())
                .firstName(userDTO.firstName())
                .lastName(userDTO.lastName())
                .imageUrl(userDTO.imageUrl())
                .email(userDTO.email())
                .phone(userDTO.phone())
                .build();
    }

    public UserRegisterResponseDto userEntityToUserRegisterResponseDTO(UserEntity userEntity) {
        return UserRegisterResponseDto.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .imageUrl(userEntity.getImageUrl())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .build();
    }

    @Override
    public Optional<UserDto> optionalEntityToUserDTO(Optional<UserEntity> userEntity) {
        return userEntity.map(user -> UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .imageUrl(user.getImageUrl())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build());
    }

    @Override
    public UserDto entityToUserDTO(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .imageUrl(user.getImageUrl())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public UserDto mergeUserDtoWithUpdates(UserDto existingUser, UpdateUserDto updates) {
        return UserDto.builder()
                .id(existingUser.id())
                .firstName(updates.firstName())
                .lastName(updates.lastName())
                .imageUrl(updates.imageUrl())
                .email(updates.email())
                .phone(updates.phone())
                .createdAt(existingUser.createdAt())
                .updatedAt(Instant.now())
                .build();
    }

}
