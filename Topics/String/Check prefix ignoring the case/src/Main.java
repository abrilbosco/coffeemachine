import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        boolean startsWith = string.toUpperCase().startsWith("J");

        System.out.println(startsWith);
    }
}