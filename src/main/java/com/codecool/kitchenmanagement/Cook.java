package com.codecool.kitchenmanagement;

import java.time.LocalDate;

public class Cook extends CookerEmployee {
    public Cook(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
    }

    @Override
    void cookWithKnives() {
        System.out.println("I'm cooking");
    }
}
