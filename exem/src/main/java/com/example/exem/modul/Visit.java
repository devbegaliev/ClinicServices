package com.example.exem.modul;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "visit_table")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = ("patient_id"), updatable = false, insertable = false)
    private Patient patientId;


    @Column(name = "patient_id")
    private Integer patient;


    @ManyToOne
    @JoinColumn(name = ("doctor_id"), updatable = false, insertable = false)
    private Doctor doctorId;

    @Column(name = "doctor_id")
    private Integer doctor;
    private String diagnos;
    private Boolean status;
    @Column(name = "create_at")
    private LocalDateTime create_at;
}
