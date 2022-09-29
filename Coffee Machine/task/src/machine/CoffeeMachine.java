package machine;

import java.util.Scanner;

enum State {
    READY,
    SHUTDOWN,
    BUY,
    WATER,
    MILK,
    COFFEE,
    CUPS,
}

public class CoffeeMachine {

    public int water;
    public int milk;
    public int coffee;
    public int cups;
    public int cash;
    public State state;
    public String input;

    public CoffeeMachine(int water, int milk, int coffee, int cups, int cash) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.cash = cash;
    }

    private void ready() {
        this.state = State.READY;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public void start() {
        ready();
    }

    public void processInput(String action) {
        this.input = action;

        switch (this.state) {
            case READY:
                processReady();
                break;
            case WATER:
            case MILK:
            case COFFEE:
            case CUPS:
                fill();
                break;
            case BUY:
                buy();
                break;
            default:
                System.out.println("Unknown state");
                ready();
                break;
        }
    }

    private void processReady() {
        switch (this.input) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                showRemaining();
                break;
            case "exit":
                shutdown();
                break;
        }
    }

    private void shutdown() {
        this.state = State.SHUTDOWN;
    }

    private void take() {
        System.out.println("I gave you $" + this.cash);
        this.cash = 0;
        ready();
    }

    private void showRemaining() {
        System.out.println("The coffee machine has");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.coffee + " g of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println("$" + this.cash + " of money");
        ready();
    }

    private void fill() {
        switch (this.state) { // WATER
            case READY:
                System.out.println("Write how many ml of water you want to add:");
                this.state = State.WATER;
                break;
            case WATER:
                this.water += Integer.parseInt(this.input);
                System.out.println("Write how many ml of milk you want to add:");
                this.state = State.MILK;
                break;
            case MILK:
                this.milk += Integer.parseInt(this.input);
                System.out.println("Write hoy many grams of coffee beans you want to add:");
                this.state = State.COFFEE;
                break;
            case COFFEE:
                this.coffee += Integer.parseInt(this.input);
                System.out.println("Write how many disposable cups you want to add:");
                this.state = State.CUPS;
                break;
            case CUPS:
                this.cups += Integer.parseInt(this.input);
                ready();
                break;
            default:
                System.out.println("Unknown fill state");
                ready();
                break;
        }
    }

    private void buy() {
        switch (this.state) {
            case READY:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                this.state = State.BUY;
                break;
            case BUY:
                boolean enough = isEnough(this.input, this.water, this.milk, this.coffee, this.cups);
                    switch (this.input) {
                        case "1":
                            if (enough) {
                                this.water -= 250;
                                this.coffee -= 16;
                                this.cups -= 1;
                                this.cash += 4;
                            }
                            break;
                        case "2":
                            if (enough) {
                                this.water -= 350;
                                this.milk -= 75;
                                this.coffee -= 20;
                                this.cups -= 1;
                                this.cash += 7;
                            }
                            break;
                        case "3":
                            if (enough) {
                                this.water -= 200;
                                this.milk -= 100;
                                this.coffee -= 12;
                                this.cups -= 1;
                                this.cash += 6;
                            }
                            break;
                        case "back":
                            break;
                    }
                    ready();
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.start();
        while (coffeeMachine.state != State.SHUTDOWN) {
            coffeeMachine.processInput(scanner.next());
        }
    }

    public boolean isEnough(String type, int water, int milk, int coffee, int cups) {
        boolean enough = false;
        int waterNeeded;
        int milkNeeded;
        int coffeeNeeded;

        switch (type) {
            case "1":
                waterNeeded = 250;
                milkNeeded = 0;
                coffeeNeeded = 16;
                break;
            case "2":
                waterNeeded = 350;
                milkNeeded = 75;
                coffeeNeeded = 20;
                break;
            case "3":
                waterNeeded = 200;
                milkNeeded = 100;
                coffeeNeeded = 12;
                break;
            default:
                return false;
        }

        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffee < coffeeNeeded) {
            System.out.println("Sorry, not enough coffee!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            enough = true;
            System.out.println("I have enough resources, making you a coffee!");
        }

        return enough;
    }
}