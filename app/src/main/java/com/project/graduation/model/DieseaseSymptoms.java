package com.project.graduation.model;

/**
 * Created by emam on 2/7/16.
 */
public class DieseaseSymptoms {
    private int id,diseasId,symptomsGategoryId;

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

    public int getSymptomsGategoryId() {
        return symptomsGategoryId;
    }

    public void setSymptomsGategoryId(int symptomsGategoryId) {
        this.symptomsGategoryId = symptomsGategoryId;
    }
}
