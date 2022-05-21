package com.example.exem.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDto {
    private Integer id;
    @NotBlank(message = "Ismida xatolik")
    private String name;
    @NotNull(message = "Familiyasi bosh bolishi mumkin emas")
    private String surname;
    @NotBlank(message = "Yonalishida xatolik")
    private String derection;
    @NotBlank(message = "Raqamida xatolik")
    private Long phone;
    @Size(min = 1,max = 20,message = "Bizda faqat 1 yildan ortig va 20 yilidan kam tajribasi bor hodimlar ishlaydi")
    private Integer experies;
    private Boolean status;
    private LocalDateTime create_at;
}
