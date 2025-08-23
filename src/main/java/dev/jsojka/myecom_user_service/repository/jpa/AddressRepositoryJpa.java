package dev.jsojka.myecom_user_service.repository.jpa;

import dev.jsojka.myecom_user_service.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepositoryJpa extends JpaRepository<AddressEntity, Integer> {

    List<AddressEntity> findByUserId(UUID user_id);
}
