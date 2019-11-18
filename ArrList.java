package com.company;

public class ArrList {
    private int[] innerArray;//внутренний массив

    public ArrList(int[] inputArray){
        innerArray = inputArray;
    }

    public void add(int value){//добавляем значение в конец структуры
        int[] bufArray = new int[innerArray.length + 1];//новый массив на 1 элемент больше исходного
        //копируем в новый массив
        for (int i = 0; i < innerArray.length; i++) {
            bufArray[i] = innerArray[i];
        }
        bufArray[innerArray.length] = value;//добавляем в конец нового массива значение
        innerArray = bufArray;//меняем ссылку на новый массив
    }

    public void add(int index, int value){//добавляем элеемент по индексу
        int[] bufArray = new int[innerArray.length + 1];//новый массив на 1 элемент больше исходного
        //копируем в новый массив, если счетчик равен индексу - вставляем переданное значение, если больше индекса - копируем дальше
        for (int i = 0; i < bufArray.length; i++) {
            if (i < index)
                bufArray[i] = innerArray[i];
            else if (i == index)
                bufArray[i] = value;
            else
                bufArray[i] = innerArray[i-1];
        }
        innerArray = bufArray;//меняем ссылку на новый массив
    }

   public void print(){//вывод всей структуры
       for (int i = 0; i < innerArray.length; i++) {
           System.out.println("[" + i + "]" + " = " + innerArray[i]);
       }

   }

   public int size(){//вывод размера коллекции
       return innerArray.length;
   }

   public void set(int index, int value){//устанавливаем значение элемента
        innerArray[index] = value;
   }

   public void remove(int index){//удаление массива по элементу
       int[] bufArray = new int[innerArray.length - 1];//новый массив на 1 элемент меньше исходного
       //копируем исходный массив в новый массив, если счетчик больше или равен переданному индексу - вставляем значение из исходного массива [счетчик - 1]
       for (int i = 0; i < bufArray.length; i++) {
           if (i < index)
               bufArray[i] = innerArray[i];
           else if (i >= index)
               bufArray[i] = innerArray[i+1];
       }
       innerArray = bufArray;//меняем ссылку на новый массив
   }

   public void fill(int value){//заполнение одним значением
        for (int i = 0; i < innerArray.length; i++) {
           innerArray[i] = value;
       }
   }

   public int maxValue(){//возвращает максимальное значение
        int maxValue = Integer.MIN_VALUE;//стартовое значение-минимум для инта
       for (int value : innerArray) {
           if (value > maxValue)
               maxValue = value;
       }
        return maxValue;
   }

   public int minValue(){//возвращает минимальное значение
        int minValue = Integer.MAX_VALUE;//стартовое значение-максимум для инта
        for (int value : innerArray) {
            if (value < minValue)
                minValue = value;
        }
        return minValue;
    }

    public void printUpSort(){//сортировка по возрастанию
        int[] buf = innerArray;
        //магия сортировки
        for (int i = 0; i < buf.length; i++) {
            for (int j = buf.length-1; j > i ; j--) {
                if(buf[j] < buf[i]){
                    int bufValue = buf[i];
                    buf[i] = buf[j];
                    buf[j] = bufValue;
                }
            }
        }
        printArray(buf);
    }

    public  void printDownSort(){
        int[] buf = innerArray;
        //магия сортировки
        for (int i = 0; i < buf.length; i++) {
            for (int j = buf.length-1; j > i ; j--) {
                if(buf[j] > buf[i]){
                    int bufValue = buf[i];
                    buf[i] = buf[j];
                    buf[j] = bufValue;
                }
            }
        }
        printArray(buf);
    }

    private static void printArray(int[] array){
        for (int value :
                array) {
            System.out.println(value);
        }
    }


}
