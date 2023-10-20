import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек делим счет?");                       //запрос количества людей с проверкой
        int nChel = getNchel();
        Calculator calculator = new Calculator();                                   //создаем объект калькулятор, чтобы в него "сохранять" товары
        String name;
        while (true) {
            System.out.println("Введи имя товара или \"Завершить\"");               //бесконечный запрос товаров с проверкой (29стр) после каждого добавления товара. break на 49 строке
            name = scanner.nextLine();
            if (!name.toLowerCase(Locale.ROOT).equals("завершить")) {
                calculator.addGood(getGood(name));
                System.out.println("Товар успешно добавлен!");
            } else {
                break;
            }
        }
        calculator.calculate(nChel);                                                //расчет по набору товаров и количеству людей. как вариант, можно возвращать String вместо вывода в методе

    }

    public static int getNchel() {
        Scanner scanner = new Scanner(System.in);
        int nChel;
        try {                                                                       //проверку на буквы без краша вижу только в try-catch
            nChel = Integer.parseInt(scanner.nextLine());                           //при использовании nextInt возникают проблемы с переносом строки Scanner
        } catch (NumberFormatException e) {
            nChel = 0;
        }
        while (nChel <= 1) {
            System.out.println("Это не имеет смысла! Попробуй еще раз!");
            try {
                nChel = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                nChel = 0;
            }
        }
        return nChel;
    }

    public static Good getGood(String name) {
        Scanner scanner = new Scanner(System.in);
        float price;
        System.out.println("Введи стоимость " + name + " в формате 00.00");
        try {                                                               //запрос стоимости с проверкой
            price = Float.parseFloat(scanner.nextLine());
        } catch (NumberFormatException e) {
            price = 0;
        }
        while (price <= 0) {
            System.out.println("Что-то не так! Попробуй ввести стоимость " + name + " в формате 00.00 еще раз!");
            try {
                price = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                price = 0;

            }
        }
        Good good = new Good(name, price);
        return good;
    }

}