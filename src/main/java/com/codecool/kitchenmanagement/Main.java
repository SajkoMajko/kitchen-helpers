package com.codecool.kitchenmanagement;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var kitchen = new Kitchen();
        LocalDate oneDate = LocalDate.of(1980, 1, 1);
        var chef = new Chef("Chef M. Gesler", oneDate, 1000);

        var cook1 = new Cook("Cook G. Ramsey", oneDate.plusYears(4), 800);
        var cook2 = new Cook("Cook A. Nother", oneDate.plusYears(2), 780);
        var cook3 = new Cook("Cook A. Nother", oneDate.plusYears(2), 780);
        var cook4 = new Cook("Cook A. Nother", oneDate.plusYears(2), 780);

        var helper1 = new KitchenHelper("Helper Kamil", oneDate.plusYears(3), 600);
        //var helper2 = new KitchenHelper("Helper Next", oneDate, 600);
        //var helper3 = new KitchenHelper("Helper Yet Another", oneDate, 600);

        chef.receiveKnife();
        cook1.receiveKnife();
        cook2.receiveKnife();
        cook3.receiveKnife();
        cook4.receiveKnife();

        List<Employee> employees = List.of(chef, cook1, cook2, cook3, cook4, helper1); //, helper2, helper3);
        employees.forEach(kitchen::hireEmployee);
        kitchen.conductAShift();
    }
}
