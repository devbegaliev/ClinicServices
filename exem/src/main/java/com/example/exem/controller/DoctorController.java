package com.example.exem.controller;

import com.example.exem.dto.DoctorDto;
import com.example.exem.modul.Doctor;
import com.example.exem.servise.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorServices doctorServices;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody DoctorDto dto) {
        DoctorDto javob = doctorServices.create(dto);
        return ResponseEntity.ok(javob);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        DoctorDto result = doctorServices.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Doctor doctor, @PathVariable("id") Integer id) {
        Boolean result = doctorServices.update(id, doctor);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Boolean result = doctorServices.delete(id);
        return ResponseEntity.ok(result);
    }

}
