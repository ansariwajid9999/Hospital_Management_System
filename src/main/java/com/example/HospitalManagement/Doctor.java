package com.example.HospitalManagement;

public class Doctor {
    private int docId;
    private String name;
    private int age;
    private String gender;
    private String specialization;

    public Doctor(Integer docId,String name, String specialization, int age, String gender) {
        this.name = name;
        this.specialization = specialization;
        this.age = age;
        this.gender = gender;
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
