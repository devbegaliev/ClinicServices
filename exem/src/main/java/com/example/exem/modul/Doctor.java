package com.example.exem.modul;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "doctor_table")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String derection;
    @Column(name = "phone",unique = true)
    private Long phone;
    private Integer experies;
    private Boolean status;
    @Column(name = "create_at")
    private LocalDateTime create_at;
}
