import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = "NO";

        if (num >= 1) {
            str = "YES";
        }

        System.out.println(str);
    }
}