package machine;

public class Machine {

    private Coffee espresso;
    private Coffee latte;
    private Coffee cappuccino;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachineState state;

    public Machine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.espresso = new Espresso(250, 0, 16, 4);
        this.latte = new Latte(350, 75, 20, 7);
        this.cappuccino = new Cappuccino(200, 100, 12, 6);
        this.state = CoffeeMachineState.OFF;
    }



    public String makeCoffee(Coffee coffee) {
        if (canIMakeThisCoffee(coffee)) {
            this.water -= coffee.waterToMake();
            this.milk -= coffee.milkToMake();
            this.beans -= coffee.beansToMake();
            this.cups--;
            this.money += coffee.price();
            return "I have enough resources, making you a coffee!";
        }
        return checkForResources(espresso);
    }

    public String checkForResources(Coffee coffee) {
        if (this.water < coffee.waterToMake()) {
            return "Sorry, not enough water!";
        }
        if (this.milk < coffee.milkToMake()) {
            return "Sorry, not enough milk!";
        }
        if (this.beans < coffee.beansToMake()) {
            return "Sorry, not enough milk!";
        }
        if (this.cups == 0) {
            return "Sorry, not enough cups!";
        }
        return null;
    }

    public boolean canIMakeThisCoffee(Coffee coffee) {
        if (this.water < coffee.waterToMake()
                || this.milk < coffee.waterToMake()
                || this.beans < coffee.beansToMake()
                || this.cups == 0) {
            return false;
        }
        return true;
    }

    public Coffee espresso() {
        return espresso;
    }

    public Coffee latte() {
        return latte;
    }

    public Coffee cappuccino() {
        return cappuccino;
    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public void giveMoney() {
        this.money = 0;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money";
    }
}
