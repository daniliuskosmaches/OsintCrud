package com.example.osintcrud.Model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
 private  Long ip;
 private Long phone;
 private String email;



}
