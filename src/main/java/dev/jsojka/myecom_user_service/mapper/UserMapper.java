package dev.jsojka.myecom_user_service.mapper;

import dev.jsojka.myecom_user_service.dto.user.UpdateUserDto;
import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterRequestDto;
import dev.jsojka.myecom_user_service.dto.user.UserRegisterResponseDto;
import dev.jsojka.myecom_user_service.model.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserMapper {
    UserDto userRegisterRequestDtoAndIdToUserDTO(UserRegisterRequestDto requestDTO, UUID userId);

    UserEntity userDtoToEntity(UserDto userDTO);

    UserRegisterResponseDto userEntityToUserRegisterResponseDTO(UserEntity userEntity);

    Optional<UserDto> optionalEntityToUserDTO(Optional<UserEntity> userEntity);

    UserDto entityToUserDTO(UserEntity user);

    UserDto mergeUserDtoWithUpdates(UserDto existingUser, UpdateUserDto updates);
}
