package ru.job4j.list;

import java.util.*;

public class ListUsage {
    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        results.add("one");
        results.add("two");
        results.add("three");
        for (String result : results) {
            System.out.println("Текущий элемент: " + result);
        }

        System.out.println("-------------------------");
        results.add(1, "four");
        for (String result : results) {
            System.out.println("Текущий элемент: " + result);
        }

        List<String> list = new ArrayList<>();
        list.add("five");
        list.add("six");
        list.addAll(results);

        System.out.println("-------------------------");
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }

        List<String> zero = new ArrayList<>();
        zero.add("zero");
        zero.add("zero");
        zero.add("zero");

        list.addAll(2, zero);
        System.out.println("-------------------------");
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }

        /* Создание неизменяемого списка */
        List<String> animal = List.of("cat", "dog", "pig");
        System.out.println("-------------------------");
        for (String result : animal) {
            System.out.println("Текущий элемент: " + result);
        }

        System.out.println("-------------------------");
        Iterator<String> iterator = animal.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }

        System.out.println("-------------------------");
        ListIterator<String> iter = animal.listIterator();
        while (iter.hasNext()) {
            System.out.println("Текущий элемент: " + iter.next());
        }

        System.out.println("-------------------------");
        ListIterator<String> iterat = animal.listIterator(1);
        while (iterat.hasNext()) {
            System.out.println("Текущий элемент: " + iterat.next());
        }

        /* Изменение элемента по индексу */
        list.set(3, "ten");
        System.out.println("-------------------------");
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }

        /* Изменяет каждый элемент в списке результатом применения оператора к каждому элементу */
        list.replaceAll(String::toUpperCase);
        System.out.println("-------------------------");
        for (String result : list) {
            System.out.println("Текущий элемент: " + result);
        }
    }
}
