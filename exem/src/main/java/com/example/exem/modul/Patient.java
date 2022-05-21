package com.example.exem.modul;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "patient_table")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private LocalDate birthday;
    private Integer age;
    private String contact;
    private Boolean status;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    private LocalDateTime createdAt;


}
