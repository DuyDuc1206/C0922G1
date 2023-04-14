package com.example.exam2.controller;

import com.example.exam2.dto.CoachDto;
import com.example.exam2.dto.CoachListDto;
import com.example.exam2.model.Coach;
import com.example.exam2.service.ICoachService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CoachController {
    @Autowired
    private ICoachService coachService;

    @GetMapping("coach")
    public ResponseEntity<Page<CoachListDto>> getAllCoach(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "5") int size,
                                                          @RequestParam(defaultValue = "") String code,
                                                          @RequestParam(defaultValue = "") String typeCoach) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("code"));
        Page<CoachListDto> coachList = coachService.getAllCoach(pageable,code,typeCoach);
        if (coachList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(coachList, HttpStatus.OK);
        }
    }

    @GetMapping("coach/{id}")
    public ResponseEntity<Coach> getById(@PathVariable Integer id) {
        Coach coach = coachService.findById(id);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @DeleteMapping("coach/{id}")
    public ResponseEntity deleteCoach(@PathVariable Integer id) {
        coachService.removeCoach(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("coach-edit/{id}")
    public ResponseEntity edit(@RequestBody CoachDto coachDto, @PathVariable int id) {
        try {
            Coach coach = new Coach();
            BeanUtils.copyProperties(coachDto, coach);
            coachService.editCoach(coach, id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("coach-create")
    public ResponseEntity create(@RequestBody CoachDto coachDto) {
        try {
            Coach coach = new Coach();
            BeanUtils.copyProperties(coachDto, coach);
            coachService.createCoach(coach);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Yêu cầu không hợp lệ", HttpStatus.BAD_REQUEST);
        }

    }
}
