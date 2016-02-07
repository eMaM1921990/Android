package com.project.graduation.model;

/**
 * Created by emam on 2/7/16.
 */
public class DoctorDisease {
    private int id,doctorId,diseasId;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDiseasId() {
        return diseasId;
    }

    public void setDiseasId(int diseasId) {
        this.diseasId = diseasId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
