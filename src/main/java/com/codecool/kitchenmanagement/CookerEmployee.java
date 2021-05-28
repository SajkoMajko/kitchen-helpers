package com.codecool.kitchenmanagement;

import java.time.LocalDate;

public abstract class CookerEmployee extends Employee {
    private boolean hasKnife;

    public CookerEmployee(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
    }

    public void receiveKnife() {
        hasKnife = true;
    }

    public boolean hasKnife() {
        return hasKnife;
    }

    public void cook() throws IllegalStateException {
        if(hasKnife){
            cookWithKnives();
        } else {
            throw new IllegalStateException("Don't have a knife");
        }
    }
    abstract void cookWithKnives();
}
