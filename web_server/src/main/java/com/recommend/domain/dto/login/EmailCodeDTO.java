package com.recommend.domain.dto.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EmailCodeDTO {
    @NotNull
    @NotEmpty
    private String email;
}
