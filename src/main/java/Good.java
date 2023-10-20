public class Good {
    String name;
    float price;

    public Good(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String addGoodString() { //формирование строки товара
        return String.format("%s %.2f\n", name, price);
    }
}
