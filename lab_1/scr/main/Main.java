package main;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringCalculator calculator = new StringCalculator();
        int result;
        int test = 0;
        while (true) {
            System.out.printf("%d Enter your string: ",test);
            String str = scan.nextLine();
            result = calculator.add(str);
            if (result != -1) {
                System.out.println("Result: " + result);
            }
            System.out.println("Press 1 to continue the program or 0 to exit: ");
            int end = Integer.parseInt(scan.nextLine());
            if (end == 0) {
                break;
            }
            test++;
        }
    }
}
