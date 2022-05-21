package com.example.exem.controller;

import com.example.exem.dto.PatientDto;
import com.example.exem.modul.Patient;
import com.example.exem.servise.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServices patientServices;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PatientDto dto) {
        PatientDto result = patientServices.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        PatientDto result = patientServices.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PatientDto patientDto, @PathVariable("id") Integer id) {
        Boolean result = patientServices.update(id, patientDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Boolean result = patientServices.delete(id);
        return ResponseEntity.ok(result);
    }


}
