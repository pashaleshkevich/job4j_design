package ru.job4j.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListUsageRemote {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ONE");
        list.add("ZERO");
        list.add("FIVE");
        list.add("FOUR");
        list.add("FOUR");
        list.add("SIX");
        list.add("TEN");
        list.add("SIX");
        list.add("SEVEN");
        list.add("FIVE");
        list.add("FOUR");
        list.add("TEN");
        list.add("FOUR");
        list.add("SIX");
        list.add("SEVEN");

        list.remove(3);
        System.out.println("-------------------------");
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }

        List<String> arrayList = new ArrayList<>();
        arrayList.add("ZERO");
        arrayList.add("ONE");
        list.removeAll(arrayList);
        System.out.println("-------------------------");
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }

        list.removeIf(string -> string.length() <= 3);
        System.out.println("-------------------------");
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }

        List<String> fiveThree = List.of("FIVE", "SEVEN");
        list.retainAll(fiveThree);
        System.out.println("-------------------------");
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }

        System.out.println("-------------------------");
        boolean check = list.contains("FIVE");
        System.out.println("Список содержит элемент FIVE: " + check);

        System.out.println("-------------------------");
        int index = list.indexOf("THREE");
        System.out.println("Индекс элемента в списке: " + index);

        System.out.println("-------------------------");
        list.add("FIVE");
        int indexFIVE = list.lastIndexOf("FIVE");
        System.out.println("Индекс элемента в списке: " + indexFIVE);

        System.out.println("-------------------------");
        int size = list.size();
        System.out.println("Размер списка равен: " + size);

        System.out.println("-------------------------");
        List<String> listt = list.subList(1, 2);
        for (String string : listt) {
            System.out.println("Текущий элемент: " + string);
        }

        System.out.println("-------------------------");
        list.sort(Comparator.reverseOrder());
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }
    }
}
