package com.company;

public class CarUtils {
    /**
     *
     * @param inputArray
     * @return
     */
    public static Car[] createCarArray(String[] inputArray){//парсим массив строк, создаем и возвращаем массив объектов
        Car[] carArray = new Car[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            carArray[i] = createCar(inputArray[i]);
        }
        return removeDuplicates(carArray);
    }

    /**
     * сравнивает поэлементно объекты на совпадения типа тс и гос.номера. при совпадении увеличивает пробег у первого элемента, второй заменяет на null
     * @param carArray
     * @return массив с null на месте дублей
     */
    private static Car[] removeDuplicates(Car[] carArray) {
        int nullNumbers = 0;
        for (int i = 0; i < carArray.length ; i++) {
            for (int j = carArray.length - 1; j > i; j--) {
                if (carArray[j] != null)
                    if (carArray[i].equal(carArray[j])){
                        carArray[i].sumMilleage(carArray[j]);
                        carArray[j] = null;
                        nullNumbers++;
                    }
            }
        }
        return getFinalizedcarArray(carArray, nullNumbers);
    }

    /**
     * Чистим массив от null-элементов
     * @param carArrayWithNulls - массив, в котором присутствуют элементы null
     * @param nullNumbers - число таких элементов
     * @return массив, очищеный от null-элементов
     */
    private static Car[] getFinalizedcarArray(Car[] carArrayWithNulls, int nullNumbers){
        Car[] cleanCarArray = new Car[carArrayWithNulls.length - nullNumbers];
        int j = 0;
        for (int i = 0; i < carArrayWithNulls.length; i++) {
            if (carArrayWithNulls[i] != null){
                cleanCarArray[j] = carArrayWithNulls[i];
                j++;
            }
        }
        return cleanCarArray;
    }
    private static Car createCar(String inputString){ // парсим строку и создаем объект Car
        String[] firstLevelSplitArr = inputString.split("_");//первый сплит-тип тачки и неразбитая строка с параметрами
        int codeCar = Integer.parseInt(firstLevelSplitArr[0].substring(1));//чистим код тачки и преобразуем в инт
        String[] secondLevelSplitArr = firstLevelSplitArr[1].split("-");//делим строку с параметрами
        String gosNumber = secondLevelSplitArr[0];
        int mileage = Integer.parseInt(secondLevelSplitArr[1]);//преобразуем в инт пробег
//создаем объект в зависимости от наличия доппараметра
        if (secondLevelSplitArr.length == 2)
            return new Car(codeCar, gosNumber, mileage);
        else{
            int dopParametr = Integer.parseInt(secondLevelSplitArr[2]);
            return new Car(codeCar, gosNumber, mileage, dopParametr);
        }
    }
    public static double findCosts(Car[] inputCarArray){//считает общие расходы на гсм
        double summaryCosts = 0;
        for (Car car : inputCarArray) {
            summaryCosts += car.getCost();
        }
        return summaryCosts;
    }
    public static double findCosts(Car[] inputCarArray, int codeCar){//считает общие расходы на гсм по типу тачки, полученному в инте
        double summaryCosts = 0;
        for (Car car : inputCarArray) {
            if (car.getCodeCar() == codeCar)
                summaryCosts += car.getCost();
        }
        return summaryCosts;
    }
    public static double findCosts(Car[] inputCarArray, String codeCar){//считает общие расходы на гсм по типу тачки, полученному в стринге
        double summaryCosts = 0;
        int codeCarInt = Integer.parseInt(codeCar.substring(1));
        for (Car car : inputCarArray) {
            if (car.getCodeCar() == codeCarInt)
                summaryCosts += car.getCost();
        }
        return summaryCosts;
    }
    public static double findMinCostType(Car[] inputCarArray){// возвращает тип авто с минимальным расходом
        double minCost = findCosts(inputCarArray, 100);
        for (int i = 200; i < 500; i += 100) {
            if (minCost > findCosts(inputCarArray, i))
                minCost = findCosts(inputCarArray, i);
        }
        return minCost;
    }
    public static double findMaxCostType(Car[] inputCarArray){
        double maxCost = findCosts(inputCarArray, 100);
        for (int i = 200; i < 500; i += 100) {
            if (maxCost < findCosts(inputCarArray, i))
                maxCost = findCosts(inputCarArray, i);
        }
        return maxCost;
    }
    public static void printSortedCars(Car[] inputCarArray, String sortType){//в разрезе каждого типа авто выводят информацию о каждом авто (тип, номер, пробег, доп. параметр)
        if (sortType.equalsIgnoreCase("milleage"))
            sortCarArrayByMilleage(inputCarArray);
        else if (sortType.equalsIgnoreCase("dopparametr"))
            sortCarArrayByDopParametr(inputCarArray);
        else{
            System.out.println("incorrect type of sort parametr. printing without sort");
        }
        for (Car car : inputCarArray) {
            System.out.println(car);
        }
    }
    private static Car[] sortCarArrayByDopParametr(Car[] inputCarArray){// сортируем массив по доппараметру
        for (int i = 0; i < inputCarArray.length; i++) {
            for (int j = inputCarArray.length - 1; j > i ; j--) {
                if(inputCarArray[j].getDopParametr() < inputCarArray[i].getDopParametr()){
                    Car bufValue = inputCarArray[i];
                    inputCarArray[i] = inputCarArray[j];
                    inputCarArray[j] = bufValue;
                }
            }
        }
        return inputCarArray;
    }
    private static Car[] sortCarArrayByMilleage(Car[] inputCarArray){// сортируем массив по пробегу
        for (int i = 0; i < inputCarArray.length; i++) {
            for (int j = inputCarArray.length - 1; j > i ; j--) {
                if(inputCarArray[j].getMileage() < inputCarArray[i].getMileage()){
                    Car bufValue = inputCarArray[i];
                    inputCarArray[i] = inputCarArray[j];
                    inputCarArray[j] = bufValue;
                }
            }
        }
        return inputCarArray;
    }
}
