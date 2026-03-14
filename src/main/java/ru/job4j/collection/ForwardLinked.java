package ru.job4j.collection;

import java.util.*;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        modCount++;
        final Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> lastElement = head;
            while (lastElement.next != null) {
                lastElement = lastElement.next;
            }
            lastElement.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> searchElement = head;
        for (int i = 0; i < index; i++) {
            searchElement = searchElement.next;
        }
        return searchElement.item;
    }

    public T deleteFirst() {
        modCount++;
        if (head == null) {
            throw new NoSuchElementException();
        }
        final T deleteFirstElement = head.item;
        final Node<T> deleteElement = head;
        head = head.next;
        deleteElement.item = null;
        deleteElement.next = null;
        size--;
        return deleteFirstElement;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> elementIter = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return elementIter != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T tempValue = elementIter.item;
                elementIter = elementIter.next;
                return tempValue;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
