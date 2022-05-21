package com.example.exem.servise;

import com.example.exem.exepsion.BadRequest;
import com.example.exem.dto.PatientDto;
import com.example.exem.modul.Patient;
import com.example.exem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServices {
    @Autowired
    private PatientRepository patientRepository;

    public PatientDto create(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patient.getName());
        patient.setSurname(patient.getSurname());
        patient.setBirthday(patient.getBirthday());
        patient.setAge(LocalDate.now().getYear() - patient.getBirthday().getYear());
        patient.setContact(patient.getContact());
        patient.setStatus(true);
        patient.setCreatedAt(LocalDateTime.now());
        patientRepository.save(patient);
        patientDto.setId(patient.getId());
        return patientDto;
    }

    public PatientDto get(Integer id) {
       Patient patient= check(id);
       PatientDto patientDto=new PatientDto();
       convertEntityToDto(patient,patientDto);
       return patientDto;
    }

    public boolean update(Integer id, PatientDto dto) {
        Patient entity = check(id);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthday(dto.getBirthday());
        entity.setAge(LocalDate.now().getYear() - dto.getBirthday().getYear());
        entity.setContact(dto.getContact());
        patientRepository.save(entity);
        return true;
    }

    public boolean delete(Integer id) {
        Patient patient = check(id);
        patientRepository.delete(patient);
        return true;
    }
    public Patient check(Integer id){
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optional.get();
    }



    public void convertEntityToDto(Patient entity, PatientDto dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setBirthday(entity.getBirthday());
        dto.setContact(entity.getContact());
    }

    public List<PatientDto> findAllByPage(Integer page, Integer size) {
        Pageable pageable=PageRequest.of(page,size);
        Page<Patient> resultPage = patientRepository.findAll(pageable);
        List<PatientDto> response = new LinkedList<>();
        for (Patient patient : resultPage) {
            PatientDto dto = new PatientDto();
            convertEntityToDto(patient, dto);
            response.add(dto);
        }
        return response;
    }
}
