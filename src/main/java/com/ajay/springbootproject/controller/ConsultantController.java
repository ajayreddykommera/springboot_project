package com.ajay.springbootproject.controller;

import com.ajay.springbootproject.entity.Consultant;
import com.ajay.springbootproject.service.IConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultants")
public class ConsultantController {

    @Autowired
    private IConsultantService consultantService;

    @GetMapping
    public List<Consultant> getAllConsultants(){
        return consultantService.getAllConsultants();
    }
    @GetMapping("/{id}")
    public Consultant getAllConsultantsById(@PathVariable Long id){
        return consultantService.getAllConsultantsById(id);
    }

    @PostMapping
    public Consultant createConsultant(@RequestBody Consultant consultant){
        return consultantService.createConsultant(consultant);
    }

    @DeleteMapping("/{id}")
    public String deleteConsultantById(@PathVariable Long id){
        return consultantService.deleteConsultantById(id);
    }

    @PutMapping("/{id}")
    public Consultant editConsultant(@PathVariable Long id,@RequestBody Consultant consultant){
        return consultantService.editConsultant(id,consultant);
    }

}
