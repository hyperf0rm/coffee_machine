package machine;

import java.util.Scanner;

public class CoffeeMachineUI {

    private Machine machine;
    private Scanner scanner;

    public CoffeeMachineUI(Scanner scanner, Machine machine) {
        this.scanner = scanner;
        this.machine = machine;
    }

    public void start() {
        machine.state = CoffeeMachineState.ON;
        while (machine.state != CoffeeMachineState.OFF) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");

            System.out.print(">");
            String action = scanner.nextLine().trim();

            processInput(action);

            System.out.println();
        }
    }

    private void processInput(String input) {

        switch (input) {
            case "exit":
                machine.state = CoffeeMachineState.OFF;
                break;
            case "buy":
                sell();
                break;
            case "fill":
                fill();
                break;
            case "take":
                System.out.println("I gave you $" + machine.getMoney());
                machine.giveMoney();
                break;
            case "remaining":
                System.out.println(this.machine);
                break;
            default:
                System.out.println("Unknown command");
                break;
        }

    }

    private void sell() {
        while (true) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String action = scanner.nextLine().trim();

            if (action.equals("back")) {
                return;
            }
            if (!action.equals("1") && !action.equals("2") && !action.equals("3")) {
                System.out.println("Unknown command");
                continue;
            }

            int coffee = Integer.parseInt(action);

            switch (coffee) {
                case 1:
                    System.out.println(machine.makeCoffee(machine.espresso()));
                    break;
                case 2:
                    System.out.println(machine.makeCoffee(machine.latte()));
                    break;
                case 3:
                    System.out.println(machine.makeCoffee(machine.cappuccino()));
                    break;
            }
            break;
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        System.out.print(">");
        int water = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        System.out.print(">");
        int milk = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        System.out.print(">");
        int beans = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        System.out.print(">");
        int cups = Integer.parseInt(scanner.nextLine());

        machine.fill(water, milk, beans, cups);
    }

}
