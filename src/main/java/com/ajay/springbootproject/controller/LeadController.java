package com.ajay.springbootproject.controller;


import com.ajay.springbootproject.entity.Lead;
import com.ajay.springbootproject.service.ILeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private ILeadService leadService;

    @GetMapping
    public List<Lead> getAllLeads(){
        return leadService.getAllLeads();
    }

    @PostMapping
    public Lead createLead(@RequestBody Lead lead){
        return leadService.createLead(lead);
    }

    @GetMapping("/{id}")
    public Lead getLeadById(@PathVariable Long id){
        return leadService.getLeadById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteLeadById(@PathVariable Long id){
        return leadService.deleteLeadById(id);
    }

    @PutMapping("/{id}")
    public Lead editLead(@PathVariable Long id ,@RequestBody Lead lead){
        return leadService.editLead(id,lead);
    }

}
