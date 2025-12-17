// UserRepository.java
package com.example.osintcrud.Repository;
import com.example.osintcrud.Model.User.UserRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserRequestDTO, Long> {
    Optional<UserRequestDTO> findByIp(Long ip);
    Optional<UserRequestDTO> findByFullName(String fullName);
    Optional<UserRequestDTO> findByEmail(String email);


}