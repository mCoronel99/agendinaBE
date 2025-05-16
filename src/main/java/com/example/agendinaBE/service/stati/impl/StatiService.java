package com.example.agendinaBE.service.stati.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.model.StatiEntity;
import com.example.agendinaBE.repository.StatiRepository;
import com.example.agendinaBE.service.stati.IStatiService;

@Service
public class StatiService implements IStatiService {

    @Autowired
    private StatiRepository statiRepository;

    @Override
    public List<StatiEntity> getAllStati() {
       List<StatiEntity> stati = statiRepository.findAll();
       return stati;
    }

}
