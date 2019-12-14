package com.company.gsm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


/**
 * Класс ввода-вывода в рамках проекта ГСМ
 * Содержит метода для сохранения и загрузки необходимых параметров
 */
public class GSMClientSession {
    final static Path FUELCONSUPTIONFILEPATH = Paths.get(".//FuelConsumption.txt"); //путь к файлу с расходом
    final static Path GASTYPEPATH = Paths.get(".//GasType.txt");//путь к файлу с типом
    static HashMap<Integer, Double> fuelConsumptionMap = null;//сюда будем грузить файл с расходом топлива
    static HashMap<Integer, Double> gasolineTypeMap = null;//сюда будем грузить файл с типом топлива
    private static GSMUser user = null;
    private static Path currentDayFile = null;

    /**
     * Начинаем сессию
     * создаем нового юзера и новый день
     * доступные команды: openday и exit
     */
    public static void startSession(){
        System.out.println("Для начала работы введите OPENDAY, для выхода введите EXIT");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (input.equalsIgnoreCase("openday")){
            user = new GSMUser();
            newday();

        } else if (input.equalsIgnoreCase("exit"))
            System.out.println("До свиданья");
        else
            System.out.println("Команда не распознана");
    }

    /**
     * Открываем новый день
     * Загружаем в мапы данные из файлов с расходом и типом топлива
     * Создаем файл с новым днем, в который будем записывать расчеты
     */
    private static void newday(){
        gasolineTypeMap = loadMap(GASTYPEPATH);
        fuelConsumptionMap = loadMap(FUELCONSUPTIONFILEPATH);
        currentDayFile = createDayFile();
    }

    /**
     * Метод загружает данные из файла по переданному пути
     * @param pathToFile путь к файлу
     * @return мапа с данными из файла, ключ-codeCar(тип авто) значение - стоимость топлива
     */
    private static HashMap<Integer, Double> loadMap(Path pathToFile){
        HashMap<Integer, Double> resultMap = new HashMap<>();
        try {
            List<String> buffer = Files.readAllLines(pathToFile);
            for (String line : buffer) {
                String[] splitLineArray = line.split("=");
                resultMap.put(Integer.parseInt(splitLineArray[0]),Double.parseDouble(splitLineArray[1]));
            }
        }
        catch (IOException e){
            System.out.println("Не могу загрузить файл" + pathToFile);
            e.printStackTrace();
        }
        return resultMap;
    }

    private static Path createDayFile(){
        Path newFile = null;

        return newFile;
    }


}
