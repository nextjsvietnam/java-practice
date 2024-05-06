package net.re;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

    }

    public static void helloWorld() {
        System.out.println(App.content());
    }

    public static String content() {
        return "Hello World!";
    }

    public static int[] scanInputs() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        return new int[] { a, b, c };
    }

    public static String readStandardInputCommand() {
        return "Please input 3 integer numbers\n";
    }

    public static void readStandardInput() {
        System.out.print(App.readStandardInputCommand());
        var inputs = App.scanInputs();
        int a = inputs[0], b = inputs[1], c = inputs[2];
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
