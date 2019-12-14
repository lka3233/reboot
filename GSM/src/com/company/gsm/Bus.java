package com.company.gsm;

import java.util.HashMap;

public class Bus extends Car{
    private String dopParametrName = "Количество перевезенных пассажиров, чел.";
    private int dopParametrValue;
    public Bus(int codeCar, String gosNumber, int mileage, int dopParametr, HashMap<Integer, Double> gasolineTypeMap, HashMap<Integer, Double> fuelConsumption) {
        super(codeCar, gosNumber,mileage, gasolineTypeMap, fuelConsumption);
        this.dopParametrValue = dopParametr;
    }
}
