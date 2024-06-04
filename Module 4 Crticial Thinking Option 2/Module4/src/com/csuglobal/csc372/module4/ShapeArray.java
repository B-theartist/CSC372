package com.csuglobal.csc372.module4;

public class ShapeArray {
 public static void main(String[] args) {
     Shape[] shapeArray = new Shape[3];

     shapeArray[0] = new Rectangle(5, 10);
     shapeArray[1] = new Circle(7);
     shapeArray[2] = new Triangle(3, 4, 5);

     for (Shape shape : shapeArray) {
         System.out.println(shape.toString());
     }
 }
}