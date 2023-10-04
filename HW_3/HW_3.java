package HW_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out
                .println("Фамилия Имя Отчество ДатаРождения(00.00.0000) НомерТелефона Пол(m/f):");
        String input = sc.nextLine();

        try {
            String[] userInput = input.split(" ");
            if (userInput.length != 6) {
                throw new Exception("Неверный формат ввода");
            }

            String lastName = userInput[0];
            String firstName = userInput[1];
            String middleName = userInput[2];
            String birthday = userInput[3];
            String phone = userInput[4];
            String sex = userInput[5];

            formatName(lastName);
            formatName(firstName);
            formatName(middleName);
            formatBirthday(birthday);
            formatPhone(phone);
            formatSex(sex);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(lastName + ".txt", true))) {
                writer.write(input + "\n");
                System.out.println("Записано");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void formatName(String name) throws Exception {
        Pattern pattern = Pattern
                .compile("[A-Za-zА-Яа-я]+");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new Exception("Неверный формат ФИО");
        }
    }

    public static void formatBirthday(String birthDate) throws Exception {
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new Exception("Неверный формат даты");
        }
    }

    public static void formatPhone(String phoneNumber) throws Exception {
        if (!phoneNumber.matches("\\d+")) {
            throw new Exception("Неверный формат телефона");
        }
    }

    public static void formatSex(String gender) throws Exception {
        if (!gender.matches("[fmFM]")) {
            throw new Exception("Неверный формат пола");
        }
    }

}
