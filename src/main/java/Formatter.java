public class Formatter {

    public static String formatResult(float sumPrice, int nChel) {
        String ending;
        float resultPayment = sumPrice / nChel;
        int lastDigits = (int) resultPayment % 100;
        if (lastDigits <= 20 && lastDigits >= 11)
            ending = "рублей"; //неочевидная ловушка, увидел в чате
        else {
            switch (lastDigits % 10) { //проверка на окончание "рубля". AS предлагает упростить представление switch, но мне пока так понятнее
                case 1:
                    ending = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    ending = "рубля";
                    break;
                default:
                    ending = "рублей";
                    break;
            }
        } //формирование финального вывода
        return String.format("\nВсего к оплате:%.2f; С каждого %.2f %s", sumPrice, resultPayment, ending);
    }
}
