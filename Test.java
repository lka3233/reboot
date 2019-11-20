package com.company;


import org.w3c.dom.ls.LSOutput;

public class Test {
    public static void main(String[] args) {
        String[] inputStringArr = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        Car[] carArray = CarUtils.createCarArray(inputStringArr);
        for (int i = 0; i < carArray.length; i++) {
            System.out.println(carArray[i]);
        }
        /*MyLinkedList list = new MyLinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(4);
        System.out.println(list.getFirst());
*/
        /*Calc calculator = new Calc();
        calculator.calculate("1 + 1");
        calculator.calculate("5 * 140");
        calculator.printCalculationHistory();
        calculator.calculate("1 + 1112");
        calculator.calculate("5 / 140");
        calculator.calculate("121 + 1");
        calculator.calculate("500 * 140");
        calculator.getLastExpression();
        calculator.getLastExpression();
        calculator.clearHistory();
        calculator.getLastExpression();*/
    }
}
