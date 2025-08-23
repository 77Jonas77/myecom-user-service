package dev.jsojka.myecom_user_service.repository.jpa;

import dev.jsojka.myecom_user_service.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositoryJpa extends JpaRepository<AddressEntity, Integer> {

}
