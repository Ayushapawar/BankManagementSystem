package edu.j2ee.e1_sb_db.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDto {

    private int id;

    @NotBlank(message = "Bank name must not be blank")
    @Size(min = 2, max = 100, message = "Bank name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Bank code must not be blank")
    @Size(min = 2, max = 10, message = "Bank code must be between 2 and 10 characters")
    private String code;

    @NotBlank(message = "Bank type must not be blank")
    private String type;
}