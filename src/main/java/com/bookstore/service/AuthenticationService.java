package com.bookstore.service;

import com.bookstore.dto.UserLoginRequestDto;
import com.bookstore.dto.UserLoginResponseDto;

public interface AuthenticationService {
    UserLoginResponseDto authenticate(UserLoginRequestDto request);
}
