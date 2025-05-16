package com.example.agendinaBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agendinaBE.service.stati.impl.StatiService;

import org.springframework.web.bind.annotation.GetMapping;
import com.example.agendinaBE.model.StatiEntity;


@RestController
@RequestMapping("api/stati")
public class StatiController {
    
    @Autowired
    private StatiService statiService;

    @GetMapping("/getAll")
    public ResponseEntity<List<StatiEntity>> getAll(){
        List<StatiEntity> listaEntity = statiService.getAllStati();
        return ResponseEntity.ok(listaEntity);
    }


}
    

