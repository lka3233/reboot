package com.company.gsm;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Утильный класс для проекта ГСМ.
 * Содержит метода для расчетов гсм
 */
public class CarUtils {
    private static ArrayList<Car> currentCarList = null;//тут будем хранить все созданные машины в текущем расчете

    /**
     *создаем пустую коллекцию для хранения авто
     */
    public static void createCarList(){
        currentCarList = new ArrayList<>();
    }

    /**
     * добавляем в текущий расчет новый автомобиль, если в листе уже есть авто такого типа с таким номером - плюсуем к нему пробег и доппараметр
     * @param carToAdd добавляемый автомобиль
     */
    public static void addCar(Car carToAdd){
        boolean foundFlag = false;//флаг наличия объекта в памяти
        ListIterator<Car> iterator = (ListIterator<Car>) currentCarList.iterator();

        while (iterator.hasNext()){
            Car nextCar = iterator.next();
            if (nextCar.equal(carToAdd)){
                nextCar.mileage += carToAdd.mileage;
                //вот тут засада, т.к. в коллеции объекты суперкласс Car без поля с доппараметром приходиться проверять тип авто по коду и приводить его к соответствующему классу
                switch (nextCar.codeCar){
                    case 200:
                        if ((nextCar instanceof HeavyCar) && (carToAdd instanceof HeavyCar))
                        ((HeavyCar) nextCar).dopParametrValue += ((HeavyCar) carToAdd).dopParametrValue;
                        break;
                    case 300:
                        if ((nextCar instanceof Bus) && (carToAdd instanceof Bus))
                            ((Bus) nextCar).dopParametrValue += ((Bus) carToAdd).dopParametrValue;
                        break;
                    case 400:
                        if ((nextCar instanceof LiftingCar) && (carToAdd instanceof LiftingCar))
                            ((LiftingCar) nextCar).dopParametrValue += ((LiftingCar) carToAdd).dopParametrValue;
                        break;
                }
                foundFlag = true;
                break;
            }
        }
        if (!(foundFlag))
            currentCarList.add(carToAdd);
    }

    /**
     * считает общие расходы на гсм
     * @return сумма расходов всех тачек
     */
    public static double findCosts(){//считает общие расходы на гсм
        double summaryCosts = 0;
        for (Car car : currentCarList) {
            summaryCosts += car.calcCost();
        }
        return summaryCosts;
    }

    /**
     * считает общие расходы на гсм по типу тачки, полученному в инте
     * @param codeCar код тачки в инте
     * @return расходы по конкретному типу машины
     */
    public static double findCosts(int codeCar){
        double summaryCosts = 0;
        for (Car car : currentCarList) {
            if (car.getCodeCar() == codeCar)
                summaryCosts += car.calcCost();
        }
        return summaryCosts;
    }

    /**
     * Метод возвращает какой тип авто за день принесло минимальный расход
     * @return тип авто в инте
     */
    public static double findMinCostType(){// возвращает тип авто с минимальным расходом
        double minCost = findCosts(100);
        for (int i = 200; i < 500; i += 100) {
            if (minCost > findCosts(i))
                minCost = findCosts(i);
        }
        return minCost;
    }

    /**
     * Метод возвращает какой тип авто за день принесло максимальный расход
     * @return тип авто в инте
     */
    public static double findMaxCostType(){
        double maxCost = findCosts(100);
        for (int i = 200; i < 500; i += 100) {
            if (maxCost < findCosts(i))
                maxCost = findCosts(i);
        }
        return maxCost;
    }

    /**
     * Вывод на экран всех машин в памяти
     */
    public static void printCars(){
        for (Car car : currentCarList) {
            System.out.println(car);
        }
    }
}
