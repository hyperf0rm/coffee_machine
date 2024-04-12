package machine;

public class Cappuccino extends Coffee {

    private int waterToMake;
    private int milkToMake;
    private int beansToMake;
    private int price;

    public Cappuccino(int waterToMake, int milkToMake, int beansToMake, int price) {
        this.waterToMake = waterToMake;
        this.milkToMake = milkToMake;
        this.beansToMake = beansToMake;
        this.price = price;
    }

    public int waterToMake() {
        return waterToMake;
    }

    public int milkToMake() {
        return milkToMake;
    }

    public int beansToMake() {
        return beansToMake;
    }

    public int price() {
        return price;
    }

}
