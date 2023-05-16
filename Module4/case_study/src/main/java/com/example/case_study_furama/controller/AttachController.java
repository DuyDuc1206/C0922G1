package com.example.case_study_furama.controller;

import com.example.case_study_furama.dto.AttachFacilityDto;
import com.example.case_study_furama.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/attach-facility")
public class AttachController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/{id}")
    public ResponseEntity<List<AttachFacilityDto>> getAttachFacility(@PathVariable int id) {
        List<AttachFacilityDto> attachFacilityDtoList = attachFacilityService.findByContractId(id);
        if (attachFacilityDtoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attachFacilityDtoList, HttpStatus.OK);
    }

}
