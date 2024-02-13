package com.nyc.sgibo.registrationloginsgibox1.service;

import com.nyc.sgibo.registrationloginsgibox1.dto.UserDto;
import com.nyc.sgibo.registrationloginsgibox1.entity.User;

import java.util.List;
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
