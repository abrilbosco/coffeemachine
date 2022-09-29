import java.util.Scanner;

class ManufacturingController {
    static int amountOfProducts;

    public static String requestProduct(String product) {
        amountOfProducts += 1;
        return amountOfProducts + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        return amountOfProducts;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String product = scanner.nextLine();
            System.out.println(ManufacturingController.requestProduct(product));
            System.out.println(ManufacturingController.getNumberOfProducts());
        }
    }
}