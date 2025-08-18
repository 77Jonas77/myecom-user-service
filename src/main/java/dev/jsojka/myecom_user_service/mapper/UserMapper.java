package dev.jsojka.myecom_user_service.mapper;

import dev.jsojka.myecom_user_service.dto.UpdateUserDTO;
import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterRequestDTO;
import dev.jsojka.myecom_user_service.dto.UserRegisterResponseDTO;
import dev.jsojka.myecom_user_service.model.UserEntity;
import org.hibernate.sql.Update;

import java.util.Optional;
import java.util.UUID;

public interface UserMapper {
    UserDTO userRegisterRequestDtoAndIdToUserDTO(UserRegisterRequestDTO requestDTO, UUID userId);

    UserEntity userDtoToEntity(UserDTO userDTO);

    UserRegisterResponseDTO userEntityToUserRegisterResponseDTO(UserEntity userEntity);

    UserDTO optionalEntityToUserDTO(Optional<UserEntity> userEntity);

    UserDTO entityToUserDTO(UserEntity user);

    UserDTO mergeUserDtoWithUpdates(UserDTO existingUser, UpdateUserDTO updates);
}
