import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean lessThanTen = num < 10;
        System.out.println(lessThanTen);
    }
}