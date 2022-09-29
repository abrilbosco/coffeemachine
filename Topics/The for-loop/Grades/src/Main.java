import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int as = 0;
        int bes = 0;
        int ces = 0;
        int des = 0;

        for (int i = 0; i < num; i++) {
            char grade = scanner.next().charAt(0);
            if (grade == 'A') {
                as += 1;
            } else if (grade == 'B') {
                bes += 1;
            } else if (grade == 'C') {
                ces += 1;
            } else {
                des += 1;
            }
        }
        System.out.print(des);
        System.out.print(" ");
        System.out.print(ces);
        System.out.print(" ");
        System.out.print(bes);
        System.out.print(" ");
        System.out.print(as);
    }
}