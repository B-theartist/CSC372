package com.csuglobal.csc372;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "LeBron James", "23 Kings Road"));
        students.add(new Student(3, "Serena Williams", "1 Grand Slam Avenue"));
        students.add(new Student(2, "Lionel Messi", "10 Football Street"));
        students.add(new Student(4, "Michael Jordan", "23 Jumpman Lane"));
        students.add(new Student(5, "Tom Brady", "12 Victory Blvd"));
        students.add(new Student(7, "Usain Bolt", "9.58 Speed Way"));
        students.add(new Student(6, "Roger Federer", "20 Grand Slam Court"));
        students.add(new Student(9, "Tiger Woods", "18 Major Drive"));
        students.add(new Student(8, "Cristiano Ronaldo", "7 Goal Street"));
        students.add(new Student(10, "Simone Biles", "4 Gold Medal Place"));
        
        System.out.println("Original list:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nSorted by name:");
        SelectionSort.selectionSort(students, new NameComparator());
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nSorted by roll number:");
        SelectionSort.selectionSort(students, new RollnoComparator());
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
