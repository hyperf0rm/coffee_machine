package machine;

public class Espresso extends Coffee {

    private int waterToMake;
    private int beansToMake;
    private int price;

    public Espresso(int waterToMake, int milkToMake, int beansToMake, int price) {
        this.waterToMake = waterToMake;
        this.beansToMake = beansToMake;
        this.price = price;
    }

    public int waterToMake() {
        return waterToMake;
    }

    public int milkToMake() {
        return 0;
    }

    public int beansToMake() {
        return beansToMake;
    }

    public int price() {
        return price;
    }

}
