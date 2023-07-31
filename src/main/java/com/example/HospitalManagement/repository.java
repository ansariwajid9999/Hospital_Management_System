package com.example.HospitalManagement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class repository {
    HashMap<Integer,Appointment> AppointmentMap=new HashMap<>();
    HashMap<Integer, Doctor> doctorDb=new HashMap<>();
    HashMap<Integer, Hospital> HospitalsMap=new HashMap<>();
    HashMap<Integer,List<Doctor>> HospitalsDoctorMap=new HashMap<>();

    public String addAppointment(Appointment appointment){
        AppointmentMap.put(appointment.getAppointmentId(), appointment);
        return "The Appointment has been booked "+appointment.getAppointmentTime()+" Kindly, Be present on the given date.";
    }
    public Integer numberOfFemaleDoctor(){
        Integer cnt=null;
        for(Integer key : doctorDb.keySet()){
            if(doctorDb.get(key).getGender().equalsIgnoreCase("Female")) cnt++;
        }
        return cnt;

    }
    public List<Doctor> DoctorsAgeIsGreater40(){
        List<Doctor> list = new ArrayList<>();
        for(Integer key : doctorDb.keySet()){
            if(doctorDb.get(key).getAge() > 40) {
                list.add(doctorDb.get(key));
            }
        }
        return list;

    }
    public String associate(int hospitalId,int docId){
        List<Doctor>list=HospitalsDoctorMap.getOrDefault(hospitalId,new ArrayList<>());
        list.add(doctorDb.get(docId));
        HospitalsDoctorMap.put(hospitalId,list);
        return "The doctor with doctorId " +docId+ " has been associated with Hospital with id " +hospitalId;

    }
    public String MostAssociateDoctor(){
        Integer max=null;
        Integer Id=null;
        String name="";
        for(Integer Key : HospitalsDoctorMap.keySet()){
            List<Doctor> list=HospitalsDoctorMap.get(Key);
            if(list.size() > max){
                max = list.size();
                Id=Key;
            }
        }
        name=HospitalsMap.get(Id).getHospitalName();
        return name;

    }

}
