package by.it.voinilo.jd01_10;
/*TaskB1. Напишите программу PrintMath, которая выводит на консоль все публичные поля и
        методы стандартного класса Math в следующем формате (тест потребует точное совпадение!):
public static float abs(float)
public static double pow(double,double)*/


import java.lang.annotation.ElementType;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class classcount =Math.class;
        Method[] methods= classcount.getDeclaredMethods();
        for (Method method : methods)
        {
            if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
                System.out.printf("%s %s %s(%s)\n","public static",method.getReturnType(), method.getName(), method.getReturnType());
        }

    }

}