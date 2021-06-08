package com.gaming.model;

public class Machine {
    private  int idMachine;
    private String nameMachine;

    public Machine(int idMachine, String nameMachine) {
        this.idMachine = idMachine;
        this.nameMachine = nameMachine;
    }

    public int getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(int idMachine) {
        this.idMachine = idMachine;
    }

    public String getNameMachine() {
        return nameMachine;
    }

    public void setNameMachine(String nameMachine) {
        this.nameMachine = nameMachine;
    }
}
