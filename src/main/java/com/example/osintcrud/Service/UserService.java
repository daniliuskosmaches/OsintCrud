package com.example.osintcrud.Service;

import com.example.osintcrud.Model.User.UserRequestDTO;
import com.example.osintcrud.Model.User.UserResponseDTO;
import com.example.osintcrud.Repository.UserRepository;

import java.util.Optional;

public class UserService {
    private UserRepository userRepository;
 private OsintService osintService;
    public UserService(UserRepository userRepository, OsintService osintService) {
        this.userRepository = userRepository;
        this.osintService = osintService;
    }
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<UserRequestDTO> GetOutput(UserRequestDTO userRequestDTO) {
        String type = osintService.identifyType(userRequestDTO);
        if (userRequestDTO == null) {
            return Optional.empty();
        }
      switch (type) {
            case "IP" -> userRepository.findByIp(Long.parseLong(String.valueOf(userRequestDTO.getIp())));
            case "FullName" -> userRepository.findByFullName(userRequestDTO.getFullName());
            case "Email" -> userRepository.findByEmail(userRequestDTO.getEmail());
            default -> Optional.empty();

        }


        return Optional.empty();
    }
}
