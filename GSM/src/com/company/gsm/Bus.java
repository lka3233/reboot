package com.company.gsm;

import java.util.HashMap;

public class Bus extends Car{
    private String dopParametrName = "Количество перевезенных пассажиров, чел.";
    public int dopParametrValue;

    public Bus(int codeCar, String gosNumber, int mileage, int dopParametr, HashMap<Integer, Double> gasolineTypeMap, HashMap<Integer, Double> fuelConsumption) {
        super(codeCar, gosNumber,mileage, gasolineTypeMap, fuelConsumption);
        this.dopParametrValue = dopParametr;
    }

    @Override
    public String toString(){
        return "Тип: С" + codeCar + " Госномер: " + gosNumber + " Пробег: " + mileage + " Тип топлива: " + gasolineType + " Расход: " + fuelConsumption + dopParametrName + " " + dopParametrValue;
    }
}
