package com.example.exam2.controller;

import com.example.exam2.model.Coach;
import com.example.exam2.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("api")
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
    @GetMapping(path = "coach",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Coach>> getAllCoach() {
        List<Coach> coachList = coachService.findAllCoach();
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


    @PutMapping(path = "coach-edit",consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity edit(@RequestBody Coach coach) {
        coachService.editCoach(coach.getEmail(), coach.getPhoneNumber(), coach.getStartTime(), coach.getEndTime(), coach.getCompanyName(),
                coach.getDestination(), coach.getStartLocation(), coach.getTypeCoach(), coach.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

//    @PostMapping(path="coach-create", consumes=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity create(@RequestBody Coach coach) {
//        if (coach == null) {
//            return new ResponseEntity("Yêu cầu không hợp lệ", HttpStatus.BAD_REQUEST);
//        }
//        coachService.createCoach(coach);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }
}
