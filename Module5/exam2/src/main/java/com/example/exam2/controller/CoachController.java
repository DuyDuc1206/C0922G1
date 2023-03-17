package com.example.exam2.controller;

import com.example.exam2.model.Coach;
import com.example.exam2.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class CoachController {
    @Autowired
    private ICoachService coachService;

    //    @GetMapping("/coach")
//    public ResponseEntity<Page<Coach>> getAllCoach(@RequestParam(defaultValue = "0") int page,
//                                                   @RequestParam(defaultValue = "5") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Coach> coachList = coachService.findAll(pageable);
//        if (coachList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(coachList, HttpStatus.OK);
//        }
//    }
    @GetMapping("/coach")
    public ResponseEntity<List<Coach>> getAllCoach() {
        List<Coach> coachList = coachService.findAllCoach();
        if (coachList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(coachList, HttpStatus.OK);
        }
    }

    @DeleteMapping("/coach/{id}")
    public ResponseEntity deleteCoach(@PathVariable int id) {
        coachService.removeCoach(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/coach/{id}")
    public ResponseEntity edit(@RequestBody Coach coach) {
        coachService.editCoach(coach, coach.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/coach")
    public ResponseEntity create(@RequestBody Coach coach) {
        coachService.create(coach);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
