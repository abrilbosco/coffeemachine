public class Main {

    public static void main(String[] args) {
        int counter = 0;

        for (Secret word : Secret.values()) {
            if (word.toString().startsWith("STAR")) {
                counter += 1;
            }
        }

        System.out.println(counter);
    }
}

/* sample enum for inspiration
enum Secret {
    STAR, CRASH, START, // ...
}

 */
