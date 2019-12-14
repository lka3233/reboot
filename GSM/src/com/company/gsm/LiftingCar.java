package com.company.gsm;

import java.util.HashMap;

public class LiftingCar extends Car{
    private String dopParametrName = "Вес поднятых грузов, тонн";
    private int dopParametrValue;
    public LiftingCar(int codeCar, String gosNumber, int mileage, int dopParametr, HashMap<Integer, Double> gasolineTypeMap, HashMap<Integer, Double> fuelConsumption) {
        super(codeCar, gosNumber,mileage, gasolineTypeMap, fuelConsumption);
        this.dopParametrValue = dopParametr;
    }
}
