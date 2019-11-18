package com.company;

public class Car {
    private int codeCar;
    private String gosNumber;
    private int mileage;
    private int dopParametr;
    private double gasolineType;
    private double fuelConsuption;
    private double cost;
    public Car(int codeCar, String gosNumber, int mileage){
        this.codeCar = codeCar;
        this.gosNumber = gosNumber;
        this.mileage = mileage;
        this.gasolineType = parseGasolineType(codeCar);
        this.fuelConsuption = parseFuelConsuption(codeCar);
        this.cost = mileage * gasolineType * fuelConsuption;
    }
    public Car(int codeCar, String gosNumber, int mileage, int dopParametr){
        this.codeCar = codeCar;
        this.gosNumber = gosNumber;
        this.mileage = mileage;
        this.dopParametr = dopParametr;
        this.gasolineType = parseGasolineType(codeCar);
        this.fuelConsuption = parseFuelConsuption(codeCar);
        this.cost = mileage * gasolineType * fuelConsuption;
    }
    @Override
    public String toString(){
        return "Тип: С" + codeCar + " Госномер: " + gosNumber + " Пробег: " + mileage + " Доп.параметр: " + dopParametr + " Тип топлива: " + gasolineType + " Расход: " + fuelConsuption;
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
    private double parseFuelConsuption(int codeCar){
        double fuelConsuption = 0;
        switch (codeCar) {
            case 100:
                fuelConsuption = 12.5;
                break;
            case 200:
                fuelConsuption = 12;
                break;
            case 300:
                fuelConsuption = 11.5;
                break;
            case 400:
                fuelConsuption = 20;
                break;
        }
        return fuelConsuption;
    }
    public double getCost(){
        return cost;
    }
    public int getCodeCar(){
        return codeCar;
    }
    public int getDopParametr(){
        return dopParametr;
    }
    public int getMileage(){
        return mileage;
    }
}
