package com.example.DTO.service;

import com.example.DTO.domain.Citizen;
import com.example.DTO.repository.CitizenRepository;
import com.example.DTO.service.interfaces.CitizenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepository citizenRepository;

    public CitizenServiceImpl(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @Override
    public List<Citizen> findAll() {
        return this.citizenRepository.findAll();
    }
}
