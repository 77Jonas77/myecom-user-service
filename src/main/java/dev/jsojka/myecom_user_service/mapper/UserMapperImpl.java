package dev.jsojka.myecom_user_service.mapper;

import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterRequestDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterResponseDTO;
import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.stereotype.Component;

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
    public UserDTO entityToUserDTO(UserEntity userEntity) {
        return UserDTO.builder()
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
}
