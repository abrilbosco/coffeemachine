import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean nose = num < 10 && num > 0;
        System.out.println(nose);
    }
}