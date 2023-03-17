package com.example.exam2.controller;

import com.example.exam2.model.CompanyName;
import com.example.exam2.service.ICompanyNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CompanyNamController {
    @Autowired
    private ICompanyNameService companyNameService;

    @GetMapping("company-name")
    public ResponseEntity<List<CompanyName>> getAll(){
        List<CompanyName> companyNameList = companyNameService.getAll();
        return new ResponseEntity<>(companyNameList, HttpStatus.OK);
    }
}
