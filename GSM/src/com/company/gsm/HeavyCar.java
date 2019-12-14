package com.company.gsm;

import java.util.HashMap;

public class HeavyCar extends Car{
    private String dopParametrName = "Объем перевезенного груза, см.куб.";
    private int dopParametrValue;
    public HeavyCar (int codeCar, String gosNumber, int mileage, int dopParametr, HashMap<Integer, Double> gasolineTypeMap, HashMap<Integer, Double> fuelConsumption) {
        super(codeCar, gosNumber,mileage, gasolineTypeMap, fuelConsumption);
        this.dopParametrValue = dopParametr;
    }

}
