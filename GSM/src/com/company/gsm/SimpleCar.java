package com.company.gsm;

public class SimpleCar extends Car{
    public SimpleCar(int codeCar, String gosNumber, int mileage){
        super(codeCar, gosNumber,mileage);
        this.gasolineType = parseGasolineType(codeCar);
        this.fuelConsumption = parseFuelConsumption(codeCar);
        this.cost = mileage * gasolineType * fuelConsumption;
    }
    private double parseGasolineType(int codeCar){
        double gasType = 0;
        switch (codeCar) {
            case 100:
                gasType = 46.10;
                break;
            case 300:
                gasType = 47.90;
                break;
            case 200:
            case 400:
                gasType = 48.90;
                break;
        }
        return gasType;
    }
    private double parseFuelConsumption(int codeCar){
        double fuelConsumption = 0;
        switch (codeCar) {
            case 100:
                fuelConsumption = 12.5;
                break;
            case 200:
                fuelConsumption = 12;
                break;
            case 300:
                fuelConsumption = 11.5;
                break;
            case 400:
                fuelConsumption = 20;
                break;
        }
        return fuelConsumption;
    }



}
