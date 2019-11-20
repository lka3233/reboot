package com.company;

public class MyLinkedList<T>{
    private int size = 0;
    private Entry first;
    private Entry last;

    private class Entry{
        private Entry next;
        private Entry prev;
        T value;

        public Entry(T value){
            this.value = value;
            size++;
        }
    }

    /**
     * Добавляет элемент в конец списка
     * @param element элемент типа Object
     */
    public void addLast(T element) {
        if (size == 0){//если список пустой
            first = last = new Entry(element);
        } else{
            Entry newElement = new Entry(element);
            last.next = newElement;
            newElement.prev = last;
            last = newElement;
        }
    }

    /**
     * Добавляет элемент в начало списка
     * @param element элемент типа Object
     */
    public void addFirst(T element){
        if (size == 0){//если список пустой
            first = last = new Entry(element);
        } else{
            Entry newElement = new Entry(element);
            first.prev = newElement;
            newElement.next = first;
            first = newElement;
        }
    }

    /**
     * Вставляет элемент в позицию "индекс". Если индекс выходит за размеры листа выводит сообщение об ошибке
     * @param index позиция вставки
     * @param element вставляемый элемент
     */
    public void add(int index, T element){
        if (isLegalOperation(index)){
            Entry bufferEntry = first;
            for (int i = 0; i < size; i++) {
                if (i == index){
                    Entry newEntry = new Entry(element);
                    newEntry.prev = bufferEntry.prev;
                    newEntry.next = bufferEntry;
                    bufferEntry.prev = newEntry;
                } else
                    bufferEntry = bufferEntry.next;
            }
        } else
            System.out.println("Out of Range");
    }

    /**
     * Возвращает значение по индексу
     * @param index индекс
     * @return объект
     */
    public T get(int index){
        if (isLegalOperation(index)){
            Entry bufferEntry = first;
            for (int i = 0; i < size; i++) {
                if (i == index){
                    return bufferEntry.value;
                } else
                    bufferEntry = bufferEntry.next;
            }
        } else
            System.out.println("Out of Range");
        return null;
    }

    /**
     * Удаляет элемент по индексу
     * @param index индекс
     */
    public void remove(int index){
        if (isLegalOperation(index)){
            Entry bufferEntry = first;
            for (int i = 0; i < size; i++) {
                if (i == index){
                    bufferEntry.next.prev = bufferEntry.prev;
                    bufferEntry.prev.next = bufferEntry.next;
                    size--;
                } else
                    bufferEntry = bufferEntry.next;
            }
        } else
            System.out.println("Out of Range");
    }
    /**
     * Проверяет введенный индекс на предмет выхода за размер листа
     * @param index индекс
     * @return true если индекс входит в пределы
     */
    private boolean isLegalOperation(int index){
        if (index >= size)
            return false;
        else
            return true;
    }

    /**
     * Возвращает размер листа
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * Возвращает значение первого элемента
     * @return
     */
    public T getFirst(){
        return first.value;
    }

    /**
     * возвращает значение последнего элемента
     * @return
     */
    public T getLast(){
        return last.value;
    }

    /**
     * возвращает последний элемент и удаляет его
     */
    public T pickLast(){
        T returnStatment = getLast();
        removeLast();
        return returnStatment;
    }

    /**
     * Удаляет последний элемент
     */
    public void removeLast(){
        if (size > 1){
            last.prev.next = null;
            last = last.prev;
            size--;
        } else {
            last = null;
            size--;
        }

    }
}
