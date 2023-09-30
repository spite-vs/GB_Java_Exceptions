package HW_2;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) throws Exception {
        System.out.println("Вы ввели: " + input());

    }

    public static String input() throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = "";
        System.out.println("Введите что-нибудь: ");
        str = sc.nextLine();
        if (str.length() < 1) {
            throw new Exception("Строка не может быть пустой");
        }
        return str;
    }
}
