package com.bookstore.dto;

import com.bookstore.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@FieldMatch(
        first = "password",
        second = "repeatPassword",
        message = "Passwords must match"
)
public class UserRegistrationRequestDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 16, message =
            "Password must be between 8 and 16 characters")
    private String password;

    @NotBlank
    @Size(min = 8, max = 16, message =
            "Password must be between 8 and 16 characters")
    private String repeatPassword;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String shippingAddress;
}
