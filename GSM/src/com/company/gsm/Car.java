package com.company.gsm;

public abstract class Car {
    protected int codeCar;
    protected String gosNumber;
    protected int mileage;
    protected double gasolineType;
    protected double fuelConsumption;
    protected double cost;
    public Car(int codeCar, String gosNumber, int mileage){
        this.codeCar = codeCar;
        this.gosNumber = gosNumber;
        this.mileage = mileage;
    }
    public String toString(){
        return "Тип: С" + codeCar + " Госномер: " + gosNumber + " Пробег: " + mileage + " Тип топлива: " + gasolineType + " Расход: " + fuelConsumption;
    }
    public boolean equal(Car car){
        if (this.getCodeCar() == car.getCodeCar() && this.getGosNumber().equals(car.getGosNumber()))
            return true;
        else
            return false;
    }
    public int getCodeCar(){
        return codeCar;
    }
    public int getMileage(){
        return mileage;
    }
    public String getGosNumber(){
        return gosNumber;
    }

    public void sumMilleage(SimpleCar car){
        this.mileage += car.getMileage();
    }
    public double getCost(){
        return cost;
    }
}
