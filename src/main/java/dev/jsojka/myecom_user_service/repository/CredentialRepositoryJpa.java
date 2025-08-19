package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.model.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepositoryJpa extends JpaRepository<CredentialEntity, Integer> {

}
