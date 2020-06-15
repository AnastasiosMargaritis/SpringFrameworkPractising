package com.example.DTO.service;

import com.example.DTO.domain.Doctor;
import com.example.DTO.repository.DoctorRepository;
import com.example.DTO.service.interfaces.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
