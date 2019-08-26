package com.museri;
import java.util.*;

class DoubleArrayExercise {
  public static void main(String[] args) {
    DoubleArrayExercise exercise = new DoubleArrayExercise();
    
    // Create a list of Integers
    List<Integer> values = Arrays.asList(1,2,3,4,5);
    ArrayList<Integer> values2= new ArrayList<Integer>();
    values2.addAll(values);
    values2.addAll(values);
    values2.forEach(System.out::println);
  }
}