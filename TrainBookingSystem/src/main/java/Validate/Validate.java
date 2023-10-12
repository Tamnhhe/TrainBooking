package Validate;

import java.util.Scanner;

public class Validate {
    public static int getInteger() {
        Scanner in = new Scanner(System.in);
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(in.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("vui lòng nhập số nguyên ");
            }
        }
        return number;
    }

    public static double getDouble() {
        Scanner in = new Scanner(System.in);
        double number = 0.0;
        while (true) {
            try {
                number = Double.parseDouble(in.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số double: ");
            }
        }
        return number;
    }


}
