public class Good { //как по мне,в данной программе данный класс необязателен, но его создание очень показательно
    String name;
    float price;

    public Good(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String addGoodString() {
        return String.format("%s %.2f\n", name, price);
    }
}
