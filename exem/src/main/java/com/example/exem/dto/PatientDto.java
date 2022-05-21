package com.example.exem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDto {

    private Integer id;
    @NotBlank(message = ("Isimda hatolik"))
    private String name; // ""
    @NotNull(message = ("Familiyasi mavjud bolish kerak"))  // hech narsa yozmagan
    @NotEmpty(message = ("Familiyasi bosh bolishi mumkun emas"))  //"" ichida narsa bolmasa
    private String surname;
    @NotNull(message = ("Invalid birthday"))
    private LocalDate birthday;
    @NotBlank(message = ("Invalid contact"))
    @Size(min = 12, max = 13, message = ("contactni togri kirit *** 12-13 oraligida"))
    private String contact;
    private Integer age;
    private Boolean status;
    private LocalDateTime createdAt;

}

