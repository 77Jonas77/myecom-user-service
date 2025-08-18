package dev.jsojka.myecom_user_service.mapper;

import dev.jsojka.myecom_user_service.dto.UpdateUserDTO;
import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterRequestDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterResponseDTO;
import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

//@Mapper(componentModel = "spring")
@Component
public class UserMapperImpl implements UserMapper {
    public UserDTO userRegisterRequestDtoAndIdToUserDTO(UserRegisterRequestDTO requestDTO, UUID userId) {
        return UserDTO.builder()
                .id(userId)
                .firstName(requestDTO.firstName())
                .lastName(requestDTO.lastName())
                .imageUrl(requestDTO.imageUrl())
                .email(requestDTO.email())
                .phone(requestDTO.phone())
                .build();
    }

    public UserEntity userDtoToEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .id(userDTO.id())
                .firstName(userDTO.firstName())
                .lastName(userDTO.lastName())
                .imageUrl(userDTO.imageUrl())
                .email(userDTO.email())
                .phone(userDTO.phone())
                .build();
    }

    public UserRegisterResponseDTO userEntityToUserRegisterResponseDTO(UserEntity userEntity) {
        return UserRegisterResponseDTO.builder()
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
    public UserDTO optionalEntityToUserDTO(Optional<UserEntity> userEntity) {
        return userEntity.map(user -> UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .imageUrl(user.getImageUrl())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build()).orElse(null);
    }

    @Override
    public UserDTO entityToUserDTO(UserEntity user) {
        return UserDTO.builder()
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

    public UserDTO mergeUserDtoWithUpdates(UserDTO existingUser, UpdateUserDTO updates) {
        return UserDTO.builder()
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
