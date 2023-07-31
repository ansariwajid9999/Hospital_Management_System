package com.example.HospitalManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerClass {
    @Autowired
    private Service ServiceObj;
    @PostMapping("/AddAppointment")
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment){
        String result= ServiceObj.addAppointment(appointment);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @GetMapping("/NumberOfFemaleDoctor")
    public ResponseEntity<Integer> numberOfFemaleDoctor(){
        Integer maxFemaleCount = ServiceObj.numberOfFemaleDoctor();

        return new ResponseEntity<>(maxFemaleCount, HttpStatus.OK);

    }
    @GetMapping("/NumberOfDoctorwhoseAgeIsgreater40")
    public ResponseEntity<List<String >> DoctorsAgeIsGreater40(){
        List<String > DoctorName = ServiceObj.DoctorsAgeIsGreater40();

        return new ResponseEntity<List<String>> (DoctorName,HttpStatus.OK);

    }
    @PostMapping("/associate")
    public ResponseEntity<String> associate(@PathVariable("docId")Integer hospitalId,@PathVariable("hospitalId")Integer docId){
        String result=ServiceObj.associate(hospitalId,docId);

        return new ResponseEntity<>(result,HttpStatus.OK);

    }
    @GetMapping("/MostAssociateDoctor")
    public String MostAssociateDoctor(){
        return ServiceObj.MostAssociateDoctor();

    }
}
