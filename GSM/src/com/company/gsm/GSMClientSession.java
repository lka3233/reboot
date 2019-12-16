package com.company.gsm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE_NEW;

/**
 * Класс ввода-вывода в рамках проекта ГСМ
 * Содержит метода для сохранения и загрузки необходимых параметров
 */
public class GSMClientSession {
    final static Path FUELCONSUPTIONFILEPATH = Paths.get("C://reboot//GSM//src//com//company//gsm//FuelConsumption.txt"); //путь к файлу с расходом
    final static Path GASTYPEPATH = Paths.get("C://reboot//GSM//src//com//company//gsm//GasType.txt");//путь к файлу с типом
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
     * создаем буфер, куда
     */
    private static void newday(){
        gasolineTypeMap = loadMap(GASTYPEPATH);
        fuelConsumptionMap = loadMap(FUELCONSUPTIONFILEPATH);
        CarUtils.createCarList();
        System.out.println("День открыт, HELP - список доступных команд ");
        waitCommand();
    }

    /**
     * Переводит сессию в режим ожидания ввода
     * Распознает введеную команду и вызывает соответствующий метод
     */
    private static void waitCommand() {
        boolean stopRecursionFlag = false;
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next().toLowerCase();
        switch (command) {
            case "add":
                addCarCommand();
                break;
            case "calc":
                System.out.println(calculateAll());
                break;
            case "type":
                calculateType();
                break;
            case "help":
            case "?":
                helpMessage();
                break;
            case "closeday":
                closeDay(false);
                stopRecursionFlag = true;
                break;
            case "exit":
                closeDay(true);
                stopRecursionFlag = true;
                break;
            default:
                System.out.println("Команда не распознана");
                break;
        }
        if (!(stopRecursionFlag))
            waitCommand();

    }

    /**
     * Выводит перечень доступных команд
     */
    private static void helpMessage() {
        System.out.println("ADD - добавить новый автомобиль в расчет\nTYPE - расчет расходов по конкретному типу автомобиля\nCALC - расчет общих затрат\nENDDAY - закрыть день\n EXIT - выход");
    }

    /**
     * Расчет затрат по введенному типу авто
     */
    private static void calculateType() {
        Scanner scanner = new Scanner(System.in);
        int codeCar;
        System.out.print("Введи код авто(без С):");
        if (scanner.hasNextInt()) {
            codeCar = scanner.nextInt();
            System.out.println("\n");
            System.out.println(getCalcTypeString(codeCar));
        } else
            System.out.println("Ошибка ввода кода авто");
    }

    /**
     * Возвращает строку с расходами по типу авто
     * @param codeCar код авто в инте
     * @return строка с расходом авто
     */
    private static String getCalcTypeString(int codeCar) {
        return "Расходы на тип: " + CarUtils.getClassName(codeCar) + " = " + CarUtils.findCosts(codeCar);
    }

    /**
     * Расчет общих расходов
     */
    private static String calculateAll() {
        return "Общие расходы = " + CarUtils.findCosts() + " минимум по классу: " + CarUtils.getClassName(CarUtils.findMinCostType()) + " максимум по классу: " + CarUtils.getClassName(CarUtils.findMaxCostType());
    }

    /**
     * Создает объект соответствующего класса исходя из введенных параметров
     */
    private static void addCarCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи код авто(без С):");
        int dopParametr;
        int codeCar = scanner.nextInt();
        System.out.println("\n");
        System.out.print("Введи гос.номер:");
        String gosNumber = scanner.next();
        System.out.println("\n");
        System.out.print("Введи пробег:");
        int milleage = scanner.nextInt();
        System.out.println("\n");

        switch (codeCar){
            case 100:
                CarUtils.addCar(new SimpleCar(codeCar,gosNumber, milleage, gasolineTypeMap, fuelConsumptionMap));
                break;
            case  300:
                System.out.print("Введите количество пассажиров");
                dopParametr = scanner.nextInt();
                System.out.println("\n");
                CarUtils.addCar(new Bus(200,gosNumber,milleage,dopParametr,gasolineTypeMap,fuelConsumptionMap));
                break;
            case 200:
                System.out.print("Введите массу груза");
                dopParametr = scanner.nextInt();
                System.out.println("\n");
                CarUtils.addCar(new HeavyCar(300,gosNumber,milleage,dopParametr,gasolineTypeMap,fuelConsumptionMap));
                break;
            case 400:
                System.out.print("Введите количество поднятых грузов");
                dopParametr = scanner.nextInt();
                System.out.println("\n");
                CarUtils.addCar(new LiftingCar(400,gosNumber,milleage,dopParametr,gasolineTypeMap,fuelConsumptionMap));
                break;
        }
        System.out.println("Автомобиль добавлен. Введите следующую команду");
    }

    private static void closeDay(boolean exitFlag) {
        saveInfoToFile();
        System.out.println("День закрыт");
        if (!(exitFlag))
            startSession();
    }

    /**
     * сохраняем в файл
     */
    private static void saveInfoToFile() {
        Calendar calendar = new GregorianCalendar();
        String fileName = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.SECOND) + ".txt";
        Path path = Paths.get(".//" + fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path,CREATE_NEW)){
            writer.write("ФИО оператора: " + user.getName() + "\n");
            writer.write("Отдел: " + user.getDepartment()+ "\n");
            writer.write("Должность: " + user.getPosition()+ "\n");
            for (Car car :
                    CarUtils.getCurrentCarList()) {
                writer.write(car.toString());
                writer.write("\n");
            }
            writer.newLine();
            writer.write("Совокупные расходы составили: " + CarUtils.findCosts()+ "\n");
            writer.write("Самые большие расходы пришлись на тип:" + CarUtils.getClassName(CarUtils.findMaxCostType())+ "\n");
            writer.write("Самые маленькие расходы пришлись на тип:" + CarUtils.getClassName(CarUtils.findMinCostType())+ "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }

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
            System.out.println("Не могу загрузить файл " + pathToFile);
            e.printStackTrace();
        }
        return resultMap;
    }

}
