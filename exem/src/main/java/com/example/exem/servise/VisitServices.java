package com.example.exem.servise;

import com.example.exem.modul.Visit;
import com.example.exem.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VisitServices {
    @Autowired
    private VisitRepository visitRepository;
    public Visit create(Visit visit) {
       visit.setCreate_at(LocalDateTime.now());
       visit.setStatus(true);
       visitRepository.save(visit);
       return visit;
    }

    public Visit get(Integer id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    public Visit update(Integer id, Visit visit) {
       Visit visit1=get(id);
       visit1.setDiagnos(visit.getDiagnos());
       visit1.setDoctor(visit.getDoctor());
       visit1.setPatient(visit.getPatient());
       visitRepository.save(visit1);
       return visit1;
    }

    public Visit delete(Integer id) {
       Visit visit=get(id);
       visitRepository.delete(visit);
       return visit;
    }
}
