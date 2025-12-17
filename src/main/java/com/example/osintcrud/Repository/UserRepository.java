// UserRepository.java
package com.example.osintcrud.Repository;
import com.example.osintcrud.Entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Entity, Long> {
    Optional<Entity> findByEmail(String email);
    Optional<Entity> findByIp(Long ip);
    List<Entity> findByPhone(Long phone);
}