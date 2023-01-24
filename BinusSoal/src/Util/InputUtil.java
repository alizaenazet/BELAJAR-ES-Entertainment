package Util;
import java.util.Scanner;



public class InputUtil {
    static Scanner Scanner = new Scanner(System.in);

    public static String input(String info ) {
        System.out.println(info + ": ");
        var data = Scanner.nextLine();
        return data;
    }
}
