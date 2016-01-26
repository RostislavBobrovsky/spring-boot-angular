package com.itechart.boot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Date birthDate;
    private Boolean hostelLive;
}