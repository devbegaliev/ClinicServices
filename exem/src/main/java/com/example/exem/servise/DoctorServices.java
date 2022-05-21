package com.example.exem.servise;

import com.example.exem.dto.DoctorDto;
import com.example.exem.modul.Doctor;
import com.example.exem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServices {
    @Autowired
    private DoctorRepository doctorRepository;
    public DoctorDto create(DoctorDto dto) {
        Doctor doctor=new Doctor();
        doctor.setName(dto.getName());
        doctor.setSurname(dto.getSurname());
        doctor.setDerection(dto.getDerection());
        doctor.setPhone(dto.getPhone());
        doctor.setExperies(dto.getExperies());
        doctor.setStatus(dto.getStatus());
        doctor.setCreate_at(dto.getCreate_at());
        doctorRepository.save(doctor);
        dto.setId(doctor.getId());
        return dto;
    }


    public DoctorDto get(Integer id) {
       Doctor doctor=check(id);
       DoctorDto dto=new DoctorDto();
       convertEntityToDto(dto,doctor);
       return dto;
    }

    private void convertEntityToDto(DoctorDto dto, Doctor doctor) {
        dto.setName(doctor.getName());
        dto.setSurname(doctor.getSurname());
        dto.setDerection(doctor.getDerection());
        dto.setPhone(doctor.getPhone());
        dto.setExperies(doctor.getExperies());
    }

    public Doctor check(Integer id){
        Optional<Doctor> optional=doctorRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    public Boolean update(Integer id, Doctor doctor) {
      Doctor doctor1=check(id);
      doctor1.setDerection(doctor.getDerection());
      doctor1.setExperies(doctor.getExperies());
      doctor1.setName(doctor.getName());
      doctor1.setPhone(doctor.getPhone());
      doctor1.setSurname(doctor.getSurname());
      doctorRepository.save(doctor1);
      return true;
    }

    public Boolean delete(Integer id) {
       Doctor doctor=check(id);
       doctorRepository.delete(doctor);
       return true;
    }
}
