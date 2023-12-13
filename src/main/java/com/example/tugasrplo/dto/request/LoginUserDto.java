package com.example.tugasrplo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class LoginUserDto {

    @NotBlank(message = "username can't blank")
    private String username;

    @NotBlank(message = "password can't blank")
    private String password;

}
