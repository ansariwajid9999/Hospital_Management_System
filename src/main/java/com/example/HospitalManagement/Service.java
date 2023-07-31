package com.example.HospitalManagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.Doc;
import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
public class Service {
    @Autowired
    private repository repositoryObj;
    public String addAppointment(Appointment appointment){
        return repositoryObj.addAppointment(appointment);

    }
    public int numberOfFemaleDoctor(){
        return repositoryObj.numberOfFemaleDoctor();

    }
    public List<String> DoctorsAgeIsGreater40(){
        List<Doctor> list = repositoryObj.DoctorsAgeIsGreater40();
        List<String> name = new ArrayList<>();
        for(Doctor d : list){
            name.add(d.getName());
        }
        return name;

    }
    public String associate(int hospitalId,int docId){
        return repositoryObj.associate(hospitalId,docId);

    }
    public String MostAssociateDoctor(){
       return repositoryObj.MostAssociateDoctor();

    }
}
