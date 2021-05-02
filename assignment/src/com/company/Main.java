package com.company;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Heap maxx_heapp = new Heap(4); //size of it
        maxx_heapp.adding_the_heap(15);
        maxx_heapp.adding_the_heap(20);
        maxx_heapp.adding_the_heap(25);
        maxx_heapp.adding_the_heap(30);
        maxx_heapp.displaying_the_heap(); //for displaying
        System.out.println("the maximum element is " + maxx_heapp.getMax());  //for finding the maximum element
        System.out.println("the heap is empty: " + maxx_heapp.isEmpty());  //checking for it's emptiness
    }
}
class Heap {
    private static final int mm = 2;
    private int[] heapp;
    private int heapp_size;

    //this is our constructor
    //heap constructor and its size(capacity)
    public Heap(int sz){
        heapp_size = 0;
        heapp = new int[ sz+1];
        Arrays.fill(heapp, -1);
    }

    //checking whether the heap is empty
    public boolean isEmpty(){
        return heapp_size ==0;
    }

    //for checking whether the heap is full
    public boolean isFull(){
        return heapp_size == heapp.length;
    }

    //parent method that returns it
    private int parentt(int j){
        return (j-1)/ mm;
    }

    //adding a new element inside the heap
    public void adding_the_heap(int element){
        if(isFull())
            throw new NoSuchElementException("Hey! The heap's full. You cannot add the element");
        heapp[heapp_size++] = element;
        heapify_up(heapp_size -1);
    }

    //for saving its properties(heap's properties) while it's inserting
    private void heapify_up(int j) {
        int saving = heapp[j];
        while(j>0 && saving > heapp[parentt(j)]){
            heapp[j] = heapp[parentt(j)];
            j = parentt(j);
        }
        heapp[j] = saving;
    }

    //function for displaying heap
    public void displaying_the_heap()
    {
        System.out.print("Heap Elements: ");
        for (int j = 0; j < heapp_size; j++)
            System.out.print(heapp[j] + " ");
        System.out.println();
    }

    //in order to return the maximum heap
    public int getMax(){
        if(isEmpty())
            throw new NoSuchElementException("The heap's empty!");
        return heapp[0];
    }
}