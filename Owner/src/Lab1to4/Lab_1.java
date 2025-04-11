package Lab1to4;

import java.util.Scanner;

public class Lab_1 {
    //Лабораторная 1
    public static void PrintBodyMassIndex(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для того, чтобы посчитать индекс массы тела, нам необходимо узнать ваш вес и рост");

        System.out.println("Пожалуйста, введите ваш рост (в сантиметрах): ");
        int height = scanner.nextInt();
        System.out.println(height);
        System.out.println("Пожалуйста, введите ваш вес (в килограммах): ");
        int weight = scanner.nextInt();

        double heightInMetres = height/100.0;
        double BOI = weight/Math.pow(heightInMetres,2);
        System.out.println("Ваш индекс массы тела - " + BOI);

        if(BOI<=16) System.out.println("Наблюдается выраженный дефицит массы тела");
        if(BOI>16 && BOI<=18.5) System.out.println("Наблюдается дефицит массы тела");
        if(BOI>18.5 && BOI<=25) System.out.println("Это нормальные значения");
        if(BOI>25 && BOI<=30) System.out.println("Наблюдается избыточная масса тела");
        if(BOI>30 && BOI<=35) System.out.println("Ожирение I степени");
        if(BOI>35 && BOI<=40) System.out.println("Ожирение II степени");
        if(BOI>40) System.out.println("Ожирение III степени");
    }

}
