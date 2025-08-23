package dev.jsojka.myecom_user_service.repository.impl;

import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.mapper.UserMapper;
import dev.jsojka.myecom_user_service.model.UserEntity;
import dev.jsojka.myecom_user_service.repository.UserRepository;
import dev.jsojka.myecom_user_service.repository.jpa.UserRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserRepositoryJpa userRepositoryJpa, UserMapper userMapper) {
        this.userRepositoryJpa = userRepositoryJpa;
        this.userMapper = userMapper;
    }

    @Override
    public UserEntity save(UserDto userDTO) {
        UserEntity user = userMapper.userDtoToEntity(userDTO);
        return userRepositoryJpa.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepositoryJpa.existsByEmail(email);
    }

    @Override
    public Optional<UserDto> findUserById(UUID userId) {
        Optional<UserEntity> user = userRepositoryJpa.findUserById(userId);
        return userMapper.optionalEntityToUserDTO(user);
    }

    @Override
    public UserDto update(UserDto user) {
        userRepositoryJpa.update(
                user.id(), user.firstName(), user.lastName(), user.email(),
                user.imageUrl(), user.phone(), user.updatedAt());
        return user;
    }

    @Override
    public void deleteById(UUID userId) {
        userRepositoryJpa.deleteById(userId);
    }
}
