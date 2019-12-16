package com.company.gsm;

import java.util.HashMap;

public class SimpleCar extends Car{

    public SimpleCar(int codeCar, String gosNumber, int mileage, HashMap<Integer, Double> gasolineTypeMap, HashMap<Integer, Double> fuelConsumption){
        super(codeCar, gosNumber,mileage, gasolineTypeMap, fuelConsumption);
    }
}
