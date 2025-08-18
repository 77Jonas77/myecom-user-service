package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.mapper.UserMapper;
import dev.jsojka.myecom_user_service.model.UserEntity;
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
    public UserEntity save(UserDTO userDTO) {
        UserEntity user = userMapper.userDtoToEntity(userDTO);
        return userRepositoryJpa.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepositoryJpa.existsByEmail(email);
    }

    @Override
    public UserDTO findUserById(UUID userId) {
        Optional<UserEntity> user = userRepositoryJpa.findUserById(userId);
        return userMapper.optionalEntityToUserDTO(user);
    }

    @Override
    public UserDTO update(UserDTO user) {
        userRepositoryJpa.update(
                user.id(), user.firstName(), user.lastName(), user.email(),
                user.imageUrl(), user.phone(), user.updatedAt());
        return user;
    }
}
