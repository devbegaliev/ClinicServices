package com.example.exem.repository;

import com.example.exem.modul.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository  extends JpaRepository<Doctor,Integer> {
}
