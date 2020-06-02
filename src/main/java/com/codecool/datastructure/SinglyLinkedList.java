package com.codecool.datastructure;

import java.util.List;

public class SinglyLinkedList {


    private class Link {

        private int value;
        private Link next;

        Link(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Returns the number at 'index'.
    public int access(int index) {
        if (index == 0) {
            return head.getValue();
        }
        Link current = head;
        Link previous = null;
        for (int i= 0; i <= index; i++){
            previous = current;
            current = current.getNext();
            if(current==null){
                break;
            }
        }
        assert previous != null;
        return previous.getValue();
    }

    // Returns the index of 'number' if it's in the array, otherwise -1;
    public int search(int number) {
        Link current = head;
        int index = 0;
        while(current.getNext() != null){
            if(current.getValue() == number){
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    // Inserts 'number' at 'index' into the array shifting elements if necessary.
    //
    // e.g. the result of inserting 42 at index 3 into [0, 1, 2, 3, 4] is [0, 1, 2, 42, 3, 4]
    public void insert(int index, int number) {
        Link valueToInsert = new Link(number);

        if(head==null && index!=0){
            return;}
        else{
            head=new Link(number);
        }
        if(index==0){
            valueToInsert.setNext(head);
            head=valueToInsert;
            return;
        }

        Link current = head;
        Link previous = null;
        for (int i= 0; i < index; i++) {
            previous = current;
            current = current.getNext();
            if (current == null){
                break;
            }
        }
        valueToInsert.setNext(current);
        previous.setNext(valueToInsert);
    }

    // Deletes the element at 'index' from the array.
    //
    //  e.g. the result of deleting index 2 from [0, 1, 2, 3, 4] is [0, 1, 3, 4]
    public void delete(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }
}
