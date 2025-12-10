package com.bookstore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginRequestDto(
        @NotBlank
        @Size(min = 4, max = 20)
        @Email
        String email,

        @NotBlank
        @Size(min = 4, max = 8)
        String password
) {
}
