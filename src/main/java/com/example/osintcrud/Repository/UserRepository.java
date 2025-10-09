package com.example.osintcrud.Repository;



import com.example.osintcrud.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    // поиск по имени
    List<UserEntity> findByEmail(String email);
    List<UserEntity> findByFullnameContainingIgnoreCase(String fullname);
    List<UserEntity> findByNumber(int number);
    List<UserEntity> findByPasport(int pasport);
}