package com.Managerment.model;

import java.util.ArrayList;

public class Gaming {

    private int machineNumbers;
    private double times;
    private String drinks;
    private String foods;
    private double bills;

    public Gaming() {
    }

    public Gaming(int machineNumbers, double times, String drinks, String foods, double bills) {
        this.machineNumbers = machineNumbers;
        this.times = times;
        this.drinks = drinks;
        this.foods = foods;
        this.bills = bills;
    }
    private ArrayList<ArrayList<Double>>fees = new ArrayList<>();
    private ArrayList<Double> drinks1 = new ArrayList<>();
    private ArrayList<Double> food1 = new ArrayList<>();
    private ArrayList<Double> time1 = new ArrayList<>();
    public double bill = -1 ;
    public void initTime(){
        fees.add(time1);
        double fees1 = -1 ;
        time1.add(fees1);
    }
    public void initDrinks(){
        fees.add(drinks1);
        double fees1 = -1 ;
        drinks1.add(fees1);
    }
    public void initFood(){
        fees.add(food1);
        double fees1 = -1 ;
        food1.add(fees1);
    }



}
