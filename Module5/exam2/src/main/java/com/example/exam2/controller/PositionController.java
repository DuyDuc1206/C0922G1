package com.example.exam2.controller;

import com.example.exam2.model.Position;
import com.example.exam2.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping("position")
    public ResponseEntity<List<Position>> getAll(){
        List<Position> positionList = positionService.getAll();
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }
}
