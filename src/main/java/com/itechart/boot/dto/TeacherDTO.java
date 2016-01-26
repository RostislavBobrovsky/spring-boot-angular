package com.itechart.boot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeacherDTO {
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
