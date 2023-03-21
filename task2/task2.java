package task2;

import java.util.Scanner;
import java.io.*;


public class task2 {

    public static void main(String[] args) {

            //выражение стремится к 1 (к единице)
            try(FileWriter writer = new FileWriter("task2/mas.txt", false))
            {
                for(int i=2; i<100; i++) {
                    writer.append(Double.toString(calculateUn(i)));
                    writer.append('\n');
                }
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }

        while(true){
            System.out.print("Введите число: ");
            Scanner in = new Scanner(System.in);
            System.out.format("Результат функции: %.6f", calculateUn(in.nextInt()));
            in.nextLine();
            System.out.println();
            System.out.println("Желаете продолжить? (введите «нет» для выхода)");
            String answer = in.nextLine();
            if (answer.equals("нет"))  break;
        }
    }
    public static double calculateUn(int n) {
        if(n < 0) {System.out.println("Для отрицательных чисел факториал не имеет смысла"); return -1; }
        double sum = 0;
        double factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            sum += factorial;
        }
        return sum / factorial;
    }
}
