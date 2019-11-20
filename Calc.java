package com.company;

public class Calc{
    private MyLinkedList<Expression> memory;//память калькулятора
    public Calc(){
        memory = new MyLinkedList<>();
    }

    /**
     * поля объекта - аргументы выражения, метод возвращает результат вычисления
     */
    class Expression{
        int val1;
        int val2;
        String operator;
        private Expression(String val1, String val2, String operator){
            this.val1 = Integer.parseInt(val1);
            this.val2 = Integer.parseInt(val2);
            this.operator = operator;
        }
        /**
         * возвращает результат вычисления
         * @return
         */
        private double findResult(){
            double result = 0;
            switch (operator) {
                case "+":
                    result = val1 + val2;
                    break;
                case "-":
                    result = val1 - val2;
                    break;
                case "/":
                    result = (double) val1 / val2;
                    break;
                case "*":
                    result = val1 * val2;
                    break;
            }
            return result;
        }
    }

    /**
     * вычисляет значение переданного простого выражения, добавляет его в память
     * @param s строка в формате a + b
     */
    public void calculate(String s){
        String[] splitArray = s.split(" ");
        Expression exp = new Expression(splitArray[0], splitArray[2], splitArray[1]);
        addInMemory(exp);
        printExpression(exp);
    }

    /**
     * выводит последнее значение из памяти, удаляя его из памяти
     */
    public void getLastExpression(){
        if(!isMemoryEmpty())
            printExpression(memory.pickLast());
        else
            System.out.println("Нет последних вычислений");
    }

    /**
     * печатает всю историю операций, удаляя ее
     */
    public void printCalculationHistory(){
        if (!isMemoryEmpty())
            while (memory.getSize() > 0){
                getLastExpression();
            }
        else
            System.out.println("Нет последних вычислений");
    }

    public void clearHistory(){
        memory = new MyLinkedList<>();
        System.out.println("Память очищена");
    }

    /**
     * выводит переданное выражение на экран
     * @param exp
     */
    private void printExpression(Expression exp) {
        System.out.println(exp.val1 + " " + exp.operator + " " + exp.val2 + " = " + exp.findResult());
    }

    /**
     * Добавляет в память выражение, если в памяти 10 - удаляет первое
     * @param expression
     */
    private void addInMemory(Expression expression){
        if (memory.getSize() <= 10)
            memory.addLast(expression);
        else{
            memory.addLast(expression);
            memory.remove(0);
        }
    }

    /**
     * возвращает true если память пуста
     * @return
     */
    private boolean isMemoryEmpty(){
        if (memory.getSize() > 0)
            return false;
        else
            return true;
    }
}

