public class Calculator {
    String goodsList = "";   //перечень товаров. правильнее, наверно, объекты добавлять в List/array, но мы этого еще вроде не проходили
    float sumPrice = 0;
    int nOfGoods = 0;       //для указания № товара в финальном оторбражении


    public void addGood(Good good) {    //товар "сохраняется" в калькуляторе
        nOfGoods++;
        sumPrice += good.price;
        goodsList += "Товар №" + nOfGoods + ": " + good.addGoodString();
    }

    public void calculate(int nChel) {  //вывод результата с проверкой на нулевую сумму товаров
        if (sumPrice == 0) System.out.println("похоже нечего считать!");
        else
            System.out.printf("%s%s", goodsList, Formatter.formatResult(sumPrice, nChel));
    }
}