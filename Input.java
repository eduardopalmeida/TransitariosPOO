import static java.lang.System.out;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static String askString(String question){
        out.println(question);
        
        return lerString();
    }
    
    public static int askInt(String question){
        out.println(question);
        
        return lerInt();
    }
    
    public static double askDouble(String question){
        out.println(question);
        
        return lerDouble();
    }
    
    public static boolean askBoolean(String question){
        out.println(question);
        
        return lerBoolean();
    }
    
    //Genericos
    
    public static String lerString() {
        final Scanner in = new Scanner(System.in);
        String input;
        do {
            try {
                input = in.nextLine();
                break;
            } catch (final InputMismatchException e) {
                System.out.println("Input Inválido. Tenta Outra Vez.");
                in.next();
                continue;
            }
        } while (true);
        return input;
    }

    public static int lerInt() {
        final Scanner in = new Scanner(System.in);
        int input;
        do {
            try {
                input = in.nextInt();
                break;
            } catch (final InputMismatchException e) {
                System.out.println("Input Inválido. Tenta Outra Vez.");
                in.next();
                continue;
            }
        } while (true);
        return input;
    }

    public static double lerDouble() {
        final Scanner in = new Scanner(System.in);
        double input;
        do {
            try {
                input = in.nextDouble();
                break;
            } catch (final InputMismatchException e) {
                System.out.println("Input Inválido. Tenta Outra Vez.");
                in.next();
                continue;
            }
        } while (true);
        return input    ;
    }

    public static boolean lerBoolean() {
        final Scanner in = new Scanner(System.in);
        boolean input;
        do {
            try {
                input = in.nextBoolean();
                break;
            } catch (final InputMismatchException e) {
                System.out.println("Input Inválido. Tenta Outra Vez.");
                in.next();
                continue;
            }
        } while (true);
        return input;
    }

    public static void lerNext() {
        final Scanner in = new Scanner(System.in);
        in.nextLine();
    }
    
    public static String primaEnter() {
        final Scanner in = new Scanner(System.in);
        String input;
        do {
            try {
                System.out.println("Prima ENTER para continuar...");
                input = in.nextLine();
                break;
            } catch (final InputMismatchException e) {
                System.out.println("Input Inválido. Tenta Outra Vez.");
                in.next();
                continue;
            }
        } while (true);
        return input;
    }

}