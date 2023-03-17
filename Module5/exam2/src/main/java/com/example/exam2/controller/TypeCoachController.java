package com.example.exam2.controller;

import com.example.exam2.model.TypeCoach;
import com.example.exam2.service.ITypeCoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TypeCoachController {
    @Autowired
    private ITypeCoachService typeCoachService;

    @GetMapping("type-coach")
    public ResponseEntity<List<TypeCoach>> getAll(){
        List<TypeCoach> typeCoachList = typeCoachService.getAll();
        return new ResponseEntity<>(typeCoachList, HttpStatus.OK);
    }
}
