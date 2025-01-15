package com.recommend.domain.dto.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegisterDTO {

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String emailCode;

    @NotNull
    @NotEmpty
    private String uname;

    @NotNull
    @NotEmpty
    private String upass;

}
