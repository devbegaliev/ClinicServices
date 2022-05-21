package com.example.exem.controller;


import com.example.exem.modul.Visit;
import com.example.exem.servise.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private VisitServices visitServices;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Visit visit) {
        Visit result = visitServices.create(visit);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        Visit result = visitServices.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Visit visit, @PathVariable("id") Integer id) {
        Visit result = visitServices.update(id, visit);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Visit result = visitServices.delete(id);
        return ResponseEntity.ok(result);
    }


}
