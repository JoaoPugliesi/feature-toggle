package io.github.joaopugliesi.featuretoggle.repository;

import io.github.joaopugliesi.featuretoggle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
