package HW_2;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println(input());

    }

    public static float input() {
        float res = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        try {
            res = sc.nextFloat();
            return res;
        } catch (Exception e) {
            System.out.println("Неверное число.");
        }
        return input();
    }
}